package com.gotreaux.aoc.commands;

import com.gotreaux.aoc.dto.PuzzleDto;
import com.gotreaux.aoc.services.PuzzleService;
import java.util.List;
import org.springframework.shell.command.CommandRegistration.OptionArity;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.context.InteractionMode;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModelBuilder;

@Command(group = "Puzzle Commands", interactionMode = InteractionMode.ALL)
public class PuzzleCommands {

    @Command(
            command = "solve-puzzle",
            description = "Solve puzzles for specified advent calendar year and day")
    public String solve(
            @Option(
                            longNames = "year",
                            shortNames = 'y',
                            description = "Solve puzzles for advent calendar year",
                            label = "YEAR",
                            arity = OptionArity.ZERO_OR_MORE)
                    Integer[] years,
            @Option(
                            longNames = "day",
                            shortNames = 'd',
                            description = "Solve puzzles for advent calendar day",
                            label = "DAY",
                            arity = OptionArity.ZERO_OR_MORE)
                    Integer[] days)
            throws Exception {
        PuzzleService puzzleService = new PuzzleService();
        List<PuzzleDto> puzzles = puzzleService.getPuzzles(List.of(years), List.of(days));

        TableModelBuilder<String> tableModelBuilder = new TableModelBuilder<>();

        tableModelBuilder
                .addRow()
                .addValue("Year")
                .addValue("Day")
                .addValue("Title")
                .addValue("Part One")
                .addValue("Part Two");

        for (PuzzleDto puzzle : puzzles) {
            tableModelBuilder
                    .addRow()
                    .addValue(String.valueOf(puzzle.year()))
                    .addValue(String.valueOf(puzzle.day()))
                    .addValue(puzzle.title())
                    .addValue(String.valueOf(puzzle.getPartOne()))
                    .addValue(String.valueOf(puzzle.getPartTwo()));
        }

        TableBuilder tableBuilder = new TableBuilder(tableModelBuilder.build());
        tableBuilder.addFullBorder(BorderStyle.fancy_light);

        return tableBuilder.build().render(120);
    }
}
