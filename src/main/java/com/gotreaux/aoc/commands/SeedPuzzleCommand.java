package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.input.writer.InputWriterFactory;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import java.io.IOException;
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
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
class SeedPuzzleCommand {

    static final String COMMAND_NAME = "seed-puzzle";
    private static final Logger logger = LoggerFactory.getLogger(SeedPuzzleCommand.class);

    private final MessageSource messageSource;
    private final HttpClient client;
    private final Collection<Puzzle> puzzles;
    private final InputWriterFactory inputWriterFactory;

    SeedPuzzleCommand(
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
            name = COMMAND_NAME,
            description = "Seed puzzle input for specified advent calendar year and day",
            help =
                    """
                    Usage: seed-puzzle [OPTIONS]

                    Seed puzzle input for specified advent calendar year and day

                    Options:
                      -y, --year    INTEGER    Seed puzzle for advent calendar year between 2015-2025 (required)
                      -d, --day     INTEGER    Seed puzzle for advent calendar day between 1-25 (required)
                      -s, --session STRING     Session ID extracted from cookie header to authenticate (required)
                      -t, --target  STRING...  Target destination(s) for puzzle input for seeding
                                               [database,resource,{filePath}] (default: database)
                    """,
            group = "Puzzle Commands")
    public String seed(
            @Option(
                            longName = "year",
                            shortName = 'y',
                            required = true,
                            description = "Seed puzzle for advent calendar year between 2015-2025")
                    @Min(2015)
                    @Max(2025)
                    Integer year,
            @Option(
                            longName = "day",
                            shortName = 'd',
                            required = true,
                            description = "Seed puzzle for advent calendar day between 1-25")
                    @Min(1)
                    @Max(25)
                    Integer day,
            @Option(
                            longName = "session",
                            shortName = 's',
                            required = true,
                            description = "Session ID extracted from cookie header to authenticate")
                    @Pattern(regexp = "^[a-f0-9]{128}$")
                    String session,
            @Option(
                            longName = "target",
                            shortName = 't',
                            description =
                                    "Target destination(s) for puzzle input for seeding [database,resource,{filePath}]",
                            defaultValue = InputWriterFactory.DATABASE_WRITER)
                    String[] targets) {
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

        var locale = Locale.getDefault();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            logger.error("Failed to send HTTP request", e);
            return messageSource.getMessage(
                    "puzzle.command.seed.io-exception", new Object[] {url}, locale);
        } catch (InterruptedException e) {
            logger.error("HTTP request was interrupted", e);
            return messageSource.getMessage(
                    "puzzle.command.seed.interrupted-exception", new Object[] {url}, locale);
        }

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
            } catch (RuntimeException e) {
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
