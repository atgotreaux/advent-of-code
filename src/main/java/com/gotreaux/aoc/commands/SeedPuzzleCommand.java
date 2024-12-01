package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.input.writer.DatabaseInputWriter;
import com.gotreaux.aoc.input.writer.FileInputWriter;
import com.gotreaux.aoc.input.writer.InputWriter;
import com.gotreaux.aoc.input.writer.ResourceInputWriter;
import com.gotreaux.aoc.persistence.repository.PuzzleRepository;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;
import org.springframework.stereotype.Component;

@Command
@Component
public class SeedPuzzleCommand {

    static final String COMMAND_NAME = "seed-puzzle";
    private static final Logger logger = LoggerFactory.getLogger(SeedPuzzleCommand.class);

    private final MessageSource messageSource;
    private final HttpClient client;
    private final Collection<Puzzle> puzzles;
    private final PuzzleRepository puzzleRepository;

    public SeedPuzzleCommand(
            MessageSource messageSource,
            HttpClient client,
            Collection<Puzzle> puzzles,
            PuzzleRepository puzzleRepository) {
        this.messageSource = messageSource;
        this.client = client;
        this.puzzles = puzzles.stream().toList();
        this.puzzleRepository = puzzleRepository;
    }

    @Command(
            command = COMMAND_NAME,
            description = "Seed puzzle input for specified advent calendar year and day",
            group = "Puzzle Commands",
            interactionMode = InteractionMode.ALL)
    public String seed(
            @Option(
                            longNames = "year",
                            shortNames = 'Y',
                            required = true,
                            description = "Seed puzzle for advent calendar year",
                            label = "Year between 2015-2023",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(value = 2015, message = "{validation.years.elements-in-range}")
                    @Max(value = 2023, message = "{validation.years.elements-in-range}")
                    Integer year,
            @Option(
                            longNames = "day",
                            shortNames = 'D',
                            required = true,
                            description = "Seed puzzle for advent calendar day",
                            label = "Day between 1-25",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(value = 1, message = "{validation.days.elements-in-range}")
                    @Max(value = 25, message = "{validation.days.elements-in-range}")
                    Integer day,
            @Option(
                            longNames = "session",
                            shortNames = 'S',
                            required = true,
                            description = "Session ID extracted from cookie header to authenticate",
                            label = "SHA-512 hash session ID",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Pattern(regexp = "^[a-f0-9]{128}$", message = "{validation.session.pattern}")
                    String session,
            @Option(
                            longNames = "target",
                            shortNames = 'T',
                            description = "Target destination(s) for puzzle input for seeding",
                            label = "[database,resource,{filePath}]",
                            arity = CommandRegistration.OptionArity.ONE_OR_MORE,
                            defaultValue = "database")
                    String[] targets)
            throws Exception {
        logger.debug(
                "Seeding puzzle of year '{}' and day '{}' to targets '{}'",
                year,
                day,
                String.join(", ", targets));

        Predicate<Puzzle> yearPredicate = new PuzzlePredicate<>(Puzzle::getYear, year);
        Predicate<Puzzle> dayPredicate = new PuzzlePredicate<>(Puzzle::getDay, day);

        Puzzle filteredPuzzle =
                puzzles.stream()
                        .filter(yearPredicate)
                        .filter(dayPredicate)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchPuzzleException(year, day));

        logger.debug("Found puzzle class '{}'", filteredPuzzle.getClass().getSimpleName());

        Map<String, InputWriter> inputWriters =
                Arrays.stream(targets)
                        .collect(
                                Collectors.toMap(
                                        Function.identity(),
                                        target -> getInputWriter(filteredPuzzle, target)));

        String url = "https://adventofcode.com/%d/day/%d/input".formatted(year, day);

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("Cookie", "session=%s".formatted(session))
                        .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Locale locale = Locale.getDefault();
        if (response.statusCode() != 200) {
            String error =
                    messageSource.getMessage(
                            "puzzle.command.seed.status-code",
                            new Object[] {response.statusCode()},
                            locale);
            logger.error(error);
            return error;
        }

        String input = response.body();
        if (input == null || input.isEmpty()) {
            String error =
                    messageSource.getMessage(
                            "puzzle.command.seed.empty-response", new Object[] {url}, locale);
            logger.error(error);
            return error;
        }

        Collection<String> successfulTargets = new ArrayList<>();
        for (Map.Entry<String, InputWriter> entry : inputWriters.entrySet()) {
            try {
                entry.getValue().write(input);
                successfulTargets.add(entry.getKey());
                logger.info("Input seeded to target '{}'", entry.getKey());
            } catch (Exception e) {
                logger.error("Failed to seed input to target '{}'", entry.getKey());
                logger.error(e.getMessage());
            }
        }

        if (successfulTargets.isEmpty()) {
            String message =
                    messageSource.getMessage(
                            "puzzle.command.seed.failed-to-seed",
                            new Object[] {String.join(", ", targets)},
                            locale);
            logger.info(message);
            return message;
        }

        String message =
                messageSource.getMessage(
                        "puzzle.command.seed.seeded",
                        new Object[] {String.join(", ", successfulTargets)},
                        locale);
        logger.info(message);
        return message;
    }

    private InputWriter getInputWriter(Puzzle puzzle, String target) {
        return switch (target) {
            case "database" ->
                    new DatabaseInputWriter(puzzleRepository, puzzle.getYear(), puzzle.getDay());
            case "resource" -> new ResourceInputWriter<>(puzzle.getClass());
            default -> {
                Path filePath = Path.of(target);
                if (Files.isRegularFile(filePath) || !Files.exists(filePath)) {
                    yield new FileInputWriter(target);
                }

                throw new IllegalStateException(
                        "Cannot create input writer for target '%s'".formatted(target));
            }
        };
    }
}
