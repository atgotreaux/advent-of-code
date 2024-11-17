package com.gotreaux.aoc.commands;

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
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Collection<Puzzle> puzzles;
    private final PuzzleRepository puzzleRepository;

    public SeedPuzzleCommand(Collection<Puzzle> puzzles, PuzzleRepository puzzleRepository) {
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
                            description = "Target destination for puzzle input for seeding",
                            label = "[database,resource,{filePath}]",
                            arity = CommandRegistration.OptionArity.ZERO_OR_ONE,
                            defaultValue = "database")
                    String target)
            throws Exception {
        Puzzle filteredPuzzle =
                puzzles.stream()
                        .filter(
                                puzzle ->
                                        new PuzzlePredicate(Puzzle::getYear)
                                                .test(puzzle, new Integer[] {year}))
                        .filter(
                                puzzle ->
                                        new PuzzlePredicate(Puzzle::getDay)
                                                .test(puzzle, new Integer[] {day}))
                        .findFirst()
                        .orElseThrow();

        String url = "https://adventofcode.com/%d/day/%d/input".formatted(year, day);

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(new URI(url))
                            .header("Cookie", "session=%s".formatted(session))
                            .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                InputWriter inputWriter = getInputWriter(filteredPuzzle, target);
                inputWriter.write(response.body());
            } else {
                logger.info("Unable to fetch puzzle input. Status code: {}", response.statusCode());
            }
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }

        return "";
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

                throw new IllegalStateException("Unexpected value: " + target);
            }
        };
    }
}
