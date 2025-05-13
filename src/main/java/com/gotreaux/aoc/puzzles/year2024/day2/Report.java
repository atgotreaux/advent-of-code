package com.gotreaux.aoc.puzzles.year2024.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

record Report(List<Integer> levels) {

    static Report of(String line) {
        var levels = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();

        return new Report(levels);
    }

    boolean isSafe(Tolerance tolerance) {
        var reports = generateReports(tolerance);

        return reports.stream().anyMatch(Report::test);
    }

    private List<Report> generateReports(Tolerance tolerance) {
        if (tolerance == Tolerance.NO) {
            return List.of(this);
        }

        return IntStream.range(-1, levels.size())
                .mapToObj(
                        i ->
                                IntStream.range(0, levels.size())
                                        .filter(index -> index != i)
                                        .mapToObj(levels::get)
                                        .toList())
                .map(Report::new)
                .toList();
    }

    private boolean test() {
        boolean increasing = true, decreasing = true;

        for (var i = 0; i < levels.size() - 1; i++) {
            var difference = levels.get(i) - levels.get(i + 1);

            if (difference == 0 || Math.abs(difference) > 3) {
                return false;
            }
            if (difference < 0) {
                decreasing = false;
            }
            if (difference > 0) {
                increasing = false;
            }
            if (!increasing && !decreasing) {
                break;
            }
        }

        return increasing || decreasing;
    }
}
