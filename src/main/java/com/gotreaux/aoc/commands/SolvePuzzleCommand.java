package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.input.reader.InputReaderFactory;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Collection;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.Option;
import org.springframework.stereotype.Component;

@Component
class SolvePuzzleCommand {

    static final String COMMAND_NAME = "solve-puzzle";
    private static final Logger logger = LoggerFactory.getLogger(SolvePuzzleCommand.class);

    private final Collection<Puzzle> puzzles;
    private final MessageSource messageSource;
    private final InputReaderFactory inputReaderFactory;

    SolvePuzzleCommand(
            Collection<Puzzle> puzzles,
            MessageSource messageSource,
            InputReaderFactory inputReaderFactory) {
        this.puzzles = puzzles.stream().toList();
        this.messageSource = messageSource;
        this.inputReaderFactory = inputReaderFactory;
    }

    @Command(
            name = COMMAND_NAME,
            description = "Solve puzzle for specified advent calendar year and day",
            help =
                    """
                    Usage: solve-puzzle [OPTIONS]

                    Solve puzzle for specified advent calendar year and day

                    Options:
                      -y, --year    INTEGER    Seed puzzle for advent calendar year between 2015-2025 (required)
                      -d, --day     INTEGER    Seed puzzle for advent calendar day between 1-25 (required)
                      -i, --input   STRING     Source of puzzle input to solve
                                               [database,resource,{filePath},{string}] (default: database)
                    """,
            group = "Puzzle Commands")
    public String solve(
            @Option(
                            longName = "year",
                            shortName = 'y',
                            required = true,
                            description = "Solve puzzle for advent calendar year between 2015-2025")
                    @Min(2015)
                    @Max(2025)
                    Integer year,
            @Option(
                            longName = "day",
                            shortName = 'd',
                            required = true,
                            description = "Solve puzzle for advent calendar day between 1-25")
                    @Min(1)
                    @Max(25)
                    Integer day,
            @Option(
                            longName = "input",
                            shortName = 'i',
                            description =
                                    "Source of puzzle input [database,resource,{filePath},{string}]",
                            defaultValue = InputReaderFactory.DATABASE_READER)
                    String input) {
        logger.debug("Solving puzzle of year '{}' and day '{}' from input '{}'", year, day, input);

        var puzzle =
                puzzles.stream()
                        .filter(p -> p.getYear() == year)
                        .filter(p -> p.getDay() == day)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchPuzzleException(year, day));

        logger.debug("Found puzzle class '{}'", puzzle.getClass().getSimpleName());

        var locale = Locale.getDefault();
        try {
            var inputReader = inputReaderFactory.create(puzzle, input);
            var output = puzzle.solve(inputReader);

            var partOne = String.valueOf(output.partOne());
            var partTwo = String.valueOf(output.partTwo());

            var code = String.format("puzzle.title.%d.%d", puzzle.getYear(), puzzle.getDay());
            var puzzleTitle = messageSource.getMessage(code, null, locale);

            return messageSource.getMessage(
                    "puzzle.command.solve.solved",
                    new Object[] {puzzleTitle, partOne, partTwo},
                    locale);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            return messageSource.getMessage(
                    "puzzle.command.solve.failed-to-solve", new Object[] {input}, locale);
        }
    }
}
