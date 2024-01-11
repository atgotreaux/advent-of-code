package com.gotreaux.aoc.puzzles.year2020.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.stream.Stream;

@ShellPuzzle(year = 2020, day = 1, title = "Report Repair")
public class ReportRepairPuzzle extends Puzzle {

    public ReportRepairPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Long> expenses = lines.map(Long::parseLong).toList();
            for (int i = 0; i < expenses.size() - 2; i++) {
                for (int j = i + 1; j < expenses.size() - 1; j++) {
                    if (expenses.get(i) + expenses.get(j) == 2020) {
                        return expenses.get(i) * expenses.get(j);
                    }
                }
            }
        }

        throw new RuntimeException("No two numbers sum to 2020!");
    }

    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Long> expenses = lines.map(Long::parseLong).toList();
            for (int i = 0; i < expenses.size() - 2; i++) {
                for (int j = i + 1; j < expenses.size() - 1; j++) {
                    for (int k = j + 1; k < expenses.size(); k++) {
                        if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
                            return expenses.get(i) * expenses.get(j) * expenses.get(k);
                        }
                    }
                }
            }
        }

        throw new RuntimeException("No three numbers sum to 2020!");
    }
}
