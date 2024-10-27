package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.annotations.ElementsInRange;
import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
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

    public SolvePuzzleCommand(Collection<Puzzle> puzzles, MessageSource messageSource) {
        this.puzzles = puzzles.stream().toList();
        this.messageSource = messageSource;
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
                            max = 2023,
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
                    Integer[] days)
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

        List<Puzzle> filteredPuzzles =
                puzzles.stream()
                        .filter(puzzle -> new PuzzlePredicate(Puzzle::getYear).test(puzzle, years))
                        .filter(puzzle -> new PuzzlePredicate(Puzzle::getDay).test(puzzle, days))
                        .toList();

        for (Puzzle filteredPuzzle : filteredPuzzles) {
            String partOne;
            String partTwo;
            try {
                InputProvider inputProvider = new FileInputProvider(filteredPuzzle.getClass());
                PuzzleOutput<?, ?> output = filteredPuzzle.solve(inputProvider);

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
