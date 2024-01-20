package com.gotreaux.aoc.puzzles.year2020.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

@ShellPuzzle(year = 2020, day = 1, title = "Report Repair")
public class ReportRepairPuzzle extends Puzzle {

    private static final int TARGET_SUM = 2020;

    public ReportRepairPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        int productOfTwoMultiples = 0;
        int productOfThreeMultiples = 0;

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Integer> expenses = lines.map(Integer::parseInt).toList();
            for (int i = 0; i < expenses.size() - 2; i++) {
                for (int j = i + 1; j < expenses.size() - 1; j++) {
                    if (expenses.get(i) + expenses.get(j) == TARGET_SUM) {
                        productOfTwoMultiples = expenses.get(i) * expenses.get(j);
                    }
                    for (int k = j + 1; k < expenses.size(); k++) {
                        if (expenses.get(i) + expenses.get(j) + expenses.get(k) == TARGET_SUM) {
                            productOfThreeMultiples =
                                    expenses.get(i) * expenses.get(j) * expenses.get(k);
                        }
                    }
                }
            }
        }

        return new PuzzleOutput<>(productOfTwoMultiples, productOfThreeMultiples);
    }
}
