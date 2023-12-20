package com.gotreaux.year2020.day1;

import com.gotreaux.Puzzle;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class ReportRepairPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        puzzle.solve();
    }

    private List<Long> expenses;

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            expenses = lines.map(Long::parseLong).toList();
        }
    }

    @Override
    public Long getPartOne() throws NoSuchElementException {
        long targetExpense = expenses.stream()
                .filter(expense -> expenses.contains(2020 - expense))
                .findFirst()
                .orElseThrow();

        return targetExpense * (2020 - targetExpense);
    }

    @Override
    public Long getPartTwo() {
        for (int i = 0; i < expenses.size() - 2; i++) {
            for (int j = i + 1; j < expenses.size() - 1; j++) {
                for (int k = j + 1; k < expenses.size(); k++) {
                    if (expenses.get(i) + expenses.get(j) + expenses.get(k) == 2020) {
                        return expenses.get(i) * expenses.get(j) * expenses.get(k);
                    }
                }
            }
        }
        return 0L;
    }
}
