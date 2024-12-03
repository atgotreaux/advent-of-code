package com.gotreaux.aoc.commands;

import static java.util.Comparator.comparingInt;

import com.gotreaux.aoc.annotations.ElementsInRange;
import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.InputReaderFactory;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;
import org.springframework.stereotype.Component;

@Command
@Component
public class SolvePuzzleCommand {

    static final String COMMAND_NAME = "solve-puzzle";
    private static final int TOTAL_AVAILABLE_WIDTH = 120;
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
            description = "Solve puzzles for specified advent calendar year(s) and day(s)",
            group = "Puzzle Commands",
            interactionMode = InteractionMode.ALL)
    public String solve(
            @Option(
                            longNames = "year",
                            shortNames = 'Y',
                            description = "Solve puzzles for advent calendar year",
                            label = "YEAR1 YEAR2 YEAR3...",
                            arity = CommandRegistration.OptionArity.ZERO_OR_MORE)
                    @ElementsInRange(
                            min = 2015,
                            max = 2024,
                            message = "{validation.years.elements-in-range}")
                    Integer[] years,
            @Option(
                            longNames = "day",
                            shortNames = 'D',
                            description = "Solve puzzles for advent calendar day",
                            label = "DAY1 DAY2 DAY3...",
                            arity = CommandRegistration.OptionArity.ZERO_OR_MORE)
                    @ElementsInRange(
                            min = 1,
                            max = 25,
                            message = "{validation.days.elements-in-range}")
                    Integer[] days,
            @Option(
                            longNames = "input",
                            shortNames = 'I',
                            description = "Source of puzzle input",
                            label = "[database,resource,{filePath},{string}]",
                            arity = CommandRegistration.OptionArity.ZERO_OR_ONE,
                            defaultValue = InputReaderFactory.DATABASE_READER)
                    String source)
            throws Exception {
        TableModelBuilder<String> tableModelBuilder = new TableModelBuilder<>();
        Locale locale = Locale.getDefault();

        tableModelBuilder
                .addRow()
                .addValue(getTableHeaderMessage("year", locale))
                .addValue(getTableHeaderMessage("day", locale))
                .addValue(getTableHeaderMessage("title", locale))
                .addValue(getTableHeaderMessage("part-one", locale))
                .addValue(getTableHeaderMessage("part-two", locale));

        Predicate<Puzzle> yearPredicate = new PuzzlePredicate<>(Puzzle::getYear, years);
        Predicate<Puzzle> dayPredicate = new PuzzlePredicate<>(Puzzle::getDay, days);
        List<Puzzle> filteredPuzzles =
                puzzles.stream()
                        .filter(yearPredicate)
                        .filter(dayPredicate)
                        .sorted(comparingInt(Puzzle::getYear).thenComparing(Puzzle::getDay))
                        .toList();

        for (Puzzle filteredPuzzle : filteredPuzzles) {
            String partOne, partTwo;
            try {
                InputReader inputReader = inputReaderFactory.create(filteredPuzzle, source);
                PuzzleOutput<?, ?> output = filteredPuzzle.solve(inputReader);

                partOne = String.valueOf(output.partOne());
                partTwo = String.valueOf(output.partTwo());
            } catch (Exception e) {
                logger.error(e.getMessage(), e);

                partOne = getMessage("puzzle.command.solve.error", locale);
                partTwo = partOne;
            }

            tableModelBuilder
                    .addRow()
                    .addValue(String.valueOf(filteredPuzzle.getYear()))
                    .addValue(String.valueOf(filteredPuzzle.getDay()))
                    .addValue(getPuzzleTitleMessage(filteredPuzzle, locale))
                    .addValue(partOne)
                    .addValue(partTwo);
        }

        TableBuilder tableBuilder = new TableBuilder(tableModelBuilder.build());
        tableBuilder.addFullBorder(BorderStyle.fancy_light);

        return tableBuilder.build().render(TOTAL_AVAILABLE_WIDTH);
    }

    private String getTableHeaderMessage(String header, Locale locale) {
        String code = String.format("puzzle.command.solve.table-header.%s", header);

        return getMessage(code, locale);
    }

    private String getPuzzleTitleMessage(Puzzle puzzle, Locale locale) {
        String code = String.format("puzzle.title.%d.%d", puzzle.getYear(), puzzle.getDay());

        return getMessage(code, locale);
    }

    private String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, locale);
    }
}
