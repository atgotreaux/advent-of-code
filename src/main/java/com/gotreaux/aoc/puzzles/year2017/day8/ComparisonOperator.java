package com.gotreaux.aoc.puzzles.year2017.day8;

import java.util.Arrays;
import java.util.NoSuchElementException;

enum ComparisonOperator {
    EQ("=="),
    NE("!="),
    LT("<"),
    GT(">"),
    LTE("<="),
    GTE(">=");

    private final String label;

    ComparisonOperator(String label) {
        this.label = label;
    }

    private String getLabel() {
        return label;
    }

    static ComparisonOperator of(String label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(comparisonOperator -> comparisonOperator.getLabel().equals(label))
                .findFirst()
                .orElseThrow();
    }
}
