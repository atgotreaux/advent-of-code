package com.gotreaux.aoc.puzzles.year2024.day2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

record Report(List<Integer> levels) {

    static Report from(String line) {
        List<Integer> levels =
                Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().toList();

        return new Report(levels);
    }

    boolean isSafe() {
        return (isAllIncreasing() || isAllDecreasing()) && isAllAdjacentDifferenceInRange();
    }

    boolean isSafeWithTolerance() {
        return isSafe() || isSingleBadLevel();
    }

    private boolean isAllIncreasing() {
        return IntStream.range(0, levels.size() - 1)
                .allMatch(i -> levels.get(i) < levels.get(i + 1));
    }

    private boolean isAllDecreasing() {
        return IntStream.range(0, levels.size() - 1)
                .allMatch(i -> levels.get(i) > levels.get(i + 1));
    }

    private boolean isAllAdjacentDifferenceInRange() {
        return IntStream.range(0, levels.size() - 1)
                .allMatch(
                        i -> {
                            int difference = Math.abs(levels.get(i) - levels.get(i + 1));
                            return difference >= 1 && difference <= 3;
                        });
    }

    private boolean isSingleBadLevel() {
        return IntStream.range(0, levels.size())
                .mapToObj(
                        i ->
                                IntStream.range(0, levels.size())
                                        .filter(index -> index != i)
                                        .mapToObj(levels::get)
                                        .toList())
                .map(Report::new)
                .map(Report::isSafe)
                .findFirst()
                .orElse(false);
    }
}
