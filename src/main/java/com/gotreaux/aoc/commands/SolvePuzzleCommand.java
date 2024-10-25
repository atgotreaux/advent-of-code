package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.annotations.EventDays;
import com.gotreaux.aoc.annotations.EventYears;
import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
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

    private static final int TOTAL_AVAILABLE_WIDTH = 120;

    private final Collection<Puzzle> puzzles;
    private final MessageSource messageSource;

    public SolvePuzzleCommand(Collection<Puzzle> puzzles, MessageSource messageSource) {
        this.puzzles = puzzles.stream().toList();
        this.messageSource = messageSource;
    }

    @Command(
            command = "solve-puzzle",
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
                    @EventYears
                    Integer[] years,
            @Option(
                            longNames = "day",
                            shortNames = 'D',
                            description = "Solve puzzles for advent calendar day",
                            label = "DAY1 DAY2 DAY3...",
                            arity = CommandRegistration.OptionArity.ZERO_OR_MORE)
                    @EventDays
                    Integer[] days)
            throws Exception {
        List<Puzzle> filteredPuzzles =
                puzzles.stream()
                        .filter(
                                puzzle ->
                                        (years.length == 0
                                                        || Arrays.asList(years)
                                                                .contains(puzzle.getYear()))
                                                && (days.length == 0
                                                        || Arrays.asList(days)
                                                                .contains(puzzle.getDay())))
                        .toList();

        TableModelBuilder<String> tableModelBuilder = new TableModelBuilder<>();

        Locale locale = Locale.getDefault();

        tableModelBuilder
                .addRow()
                .addValue(
                        messageSource.getMessage(
                                "puzzle.command.solve.table-header.year", null, locale))
                .addValue(
                        messageSource.getMessage(
                                "puzzle.command.solve.table-header.day", null, locale))
                .addValue(
                        messageSource.getMessage(
                                "puzzle.command.solve.table-header.title", null, locale))
                .addValue(
                        messageSource.getMessage(
                                "puzzle.command.solve.table-header.part-one", null, locale))
                .addValue(
                        messageSource.getMessage(
                                "puzzle.command.solve.table-header.part-two", null, locale));

        for (Puzzle filteredPuzzle : filteredPuzzles) {
            InputProvider inputProvider = new FileInputProvider(filteredPuzzle.getClass());
            PuzzleOutput<?, ?> output = filteredPuzzle.solve(inputProvider);
            String puzzleTitle =
                    String.format(
                            "puzzle.title.%s.%s",
                            filteredPuzzle.getYear(), filteredPuzzle.getDay());

            tableModelBuilder
                    .addRow()
                    .addValue(String.valueOf(filteredPuzzle.getYear()))
                    .addValue(String.valueOf(filteredPuzzle.getDay()))
                    .addValue(messageSource.getMessage(puzzleTitle, null, locale))
                    .addValue(String.valueOf(output.partOne()))
                    .addValue(String.valueOf(output.partTwo()));
        }

        TableBuilder tableBuilder = new TableBuilder(tableModelBuilder.build());
        tableBuilder.addFullBorder(BorderStyle.fancy_light);

        return tableBuilder.build().render(TOTAL_AVAILABLE_WIDTH);
    }
}
