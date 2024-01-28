package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.annotations.EventDays;
import com.gotreaux.aoc.annotations.EventYears;
import com.gotreaux.aoc.dto.PuzzleDto;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.services.PuzzleService;
import java.util.List;
import org.springframework.shell.command.CommandRegistration;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;

@Command(group = "Puzzle Commands", interactionMode = InteractionMode.ALL)
public class PuzzleCommands {

    private static final int TOTAL_AVAILABLE_WIDTH = 120;

    @Command(
            command = "solve-puzzle",
            description = "Solve puzzles for specified advent calendar year(s) and day(s)")
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
        List<PuzzleDto> puzzles = PuzzleService.getPuzzles(List.of(years), List.of(days));

        TableModelBuilder<String> tableModelBuilder = new TableModelBuilder<>();

        tableModelBuilder
                .addRow()
                .addValue("Year")
                .addValue("Day")
                .addValue("Title")
                .addValue("Part One")
                .addValue("Part Two");

        for (PuzzleDto puzzle : puzzles) {
            PuzzleOutput<?, ?> output = puzzle.getOutput();

            tableModelBuilder
                    .addRow()
                    .addValue(String.valueOf(puzzle.year()))
                    .addValue(String.valueOf(puzzle.day()))
                    .addValue(puzzle.title())
                    .addValue(String.valueOf(output.partOne()))
                    .addValue(String.valueOf(output.partTwo()));
        }

        TableBuilder tableBuilder = new TableBuilder(tableModelBuilder.build());
        tableBuilder.addFullBorder(BorderStyle.fancy_light);

        return tableBuilder.build().render(TOTAL_AVAILABLE_WIDTH);
    }
}
