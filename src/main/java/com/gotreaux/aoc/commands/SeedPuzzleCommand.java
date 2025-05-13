package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.input.writer.InputWriterFactory;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.function.Function;
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
    private final InputWriterFactory inputWriterFactory;

    public SeedPuzzleCommand(
            MessageSource messageSource,
            HttpClient client,
            Collection<Puzzle> puzzles,
            InputWriterFactory inputWriterFactory) {
        this.messageSource = messageSource;
        this.client = client;
        this.puzzles = puzzles.stream().toList();
        this.inputWriterFactory = inputWriterFactory;
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
                            label = "Year between 2015-2024",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(2015)
                    @Max(2024)
                    Integer year,
            @Option(
                            longNames = "day",
                            shortNames = 'D',
                            required = true,
                            description = "Seed puzzle for advent calendar day",
                            label = "Day between 1-25",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(1)
                    @Max(25)
                    Integer day,
            @Option(
                            longNames = "session",
                            shortNames = 'S',
                            required = true,
                            description = "Session ID extracted from cookie header to authenticate",
                            label = "SHA-512 hash session ID",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Pattern(regexp = "^[a-f0-9]{128}$")
                    String session,
            @Option(
                            longNames = "target",
                            shortNames = 'T',
                            description = "Target destination(s) for puzzle input for seeding",
                            label = "[database,resource,{filePath}]",
                            arity = CommandRegistration.OptionArity.ZERO_OR_MORE,
                            defaultValue = InputWriterFactory.DATABASE_WRITER)
                    String[] targets)
            throws Exception {
        logger.debug(
                "Seeding puzzle of year '{}' and day '{}' to targets '{}'",
                year,
                day,
                String.join(", ", targets));

        var puzzle =
                puzzles.stream()
                        .filter(p -> p.getYear() == year)
                        .filter(p -> p.getDay() == day)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchPuzzleException(year, day));

        logger.debug("Found puzzle class '{}'", puzzle.getClass().getSimpleName());

        var inputWriters =
                Arrays.stream(targets)
                        .collect(
                                Collectors.toMap(
                                        Function.identity(),
                                        target -> inputWriterFactory.create(puzzle, target)));

        var url = "https://adventofcode.com/%d/day/%d/input".formatted(year, day);

        var request =
                HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("Cookie", "session=%s".formatted(session))
                        .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        var locale = Locale.getDefault();
        if (response.statusCode() != HttpURLConnection.HTTP_OK) {
            return messageSource.getMessage(
                    "puzzle.command.seed.status-code",
                    new Object[] {response.statusCode()},
                    locale);
        }

        var input = response.body();
        if (input == null || input.isEmpty()) {
            return messageSource.getMessage(
                    "puzzle.command.seed.empty-response", new Object[] {url}, locale);
        }

        Collection<String> successfulTargets = new ArrayList<>(inputWriters.size());
        for (var entry : inputWriters.entrySet()) {
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
            return messageSource.getMessage(
                    "puzzle.command.seed.failed-to-seed",
                    new Object[] {String.join(", ", targets)},
                    locale);
        }

        return messageSource.getMessage(
                "puzzle.command.seed.seeded",
                new Object[] {String.join(", ", successfulTargets)},
                locale);
    }
}
