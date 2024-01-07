package com.gotreaux.commands;

import com.gotreaux.records.PuzzleResult;
import com.gotreaux.services.PuzzleService;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.shell.command.CommandRegistration.OptionArity;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.shell.table.BeanListTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;

@Command(group = "Puzzle Commands")
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
        List<PuzzleResult> puzzleResults = puzzleService.getPuzzles(List.of(years), List.of(days));

        LinkedHashMap<String, Object> headers = new LinkedHashMap<>();
        headers.put("year", "Year");
        headers.put("day", "Day");
        headers.put("title", "Title");
        headers.put("partOne", "Part One");
        headers.put("partTwo", "Part Two");

        BeanListTableModel<PuzzleResult> beanListTableModel =
                new BeanListTableModel<>(puzzleResults, headers);

        TableBuilder tableBuilder = new TableBuilder(beanListTableModel);
        tableBuilder.addFullBorder(BorderStyle.fancy_light);

        return tableBuilder.build().render(120);
    }
}
