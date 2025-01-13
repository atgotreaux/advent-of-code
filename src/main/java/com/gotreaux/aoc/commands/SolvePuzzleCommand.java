package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.exceptions.NoSuchPuzzleException;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.InputReaderFactory;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.Collection;
import java.util.Locale;
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
public class SolvePuzzleCommand {

    static final String COMMAND_NAME = "solve-puzzle";
    private static final Logger logger = LoggerFactory.getLogger(SolvePuzzleCommand.class);

    private final Collection<Puzzle> puzzles;
    private final MessageSource messageSource;
    private final InputReaderFactory inputReaderFactory;

    public SolvePuzzleCommand(
            Collection<Puzzle> puzzles,
            MessageSource messageSource,
            InputReaderFactory inputReaderFactory) {
        this.puzzles = puzzles.stream().toList();
        this.messageSource = messageSource;
        this.inputReaderFactory = inputReaderFactory;
    }

    @Command(
            command = COMMAND_NAME,
            description = "Solve puzzle for specified advent calendar year and day",
            group = "Puzzle Commands",
            interactionMode = InteractionMode.ALL)
    public String solve(
            @Option(
                            longNames = "year",
                            shortNames = 'Y',
                            required = true,
                            description = "Solve puzzle for advent calendar year",
                            label = "Year between 2015-2024",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(2015)
                    @Max(2024)
                    Integer year,
            @Option(
                            longNames = "day",
                            shortNames = 'D',
                            required = true,
                            description = "Solve puzzle for advent calendar day",
                            label = "Day between 1-25",
                            arity = CommandRegistration.OptionArity.EXACTLY_ONE)
                    @Min(1)
                    @Max(25)
                    Integer day,
            @Option(
                            longNames = "input",
                            shortNames = 'I',
                            description = "Source of puzzle input",
                            label = "[database,resource,{filePath},{string}]",
                            arity = CommandRegistration.OptionArity.ZERO_OR_ONE,
                            defaultValue = InputReaderFactory.DATABASE_READER)
                    String input)
            throws Exception {
        logger.debug("Solving puzzle of year '{}' and day '{}' from input '{}'", year, day, input);

        Puzzle puzzle =
                puzzles.stream()
                        .filter(p -> p.getYear() == year)
                        .filter(p -> p.getDay() == day)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchPuzzleException(year, day));

        logger.debug("Found puzzle class '{}'", puzzle.getClass().getSimpleName());

        Locale locale = Locale.getDefault();
        try {
            InputReader inputReader = inputReaderFactory.create(puzzle, input);
            PuzzleOutput<?, ?> output = puzzle.solve(inputReader);

            String partOne = String.valueOf(output.partOne());
            String partTwo = String.valueOf(output.partTwo());

            String code = String.format("puzzle.title.%d.%d", puzzle.getYear(), puzzle.getDay());
            String puzzleTitle = messageSource.getMessage(code, null, locale);

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
