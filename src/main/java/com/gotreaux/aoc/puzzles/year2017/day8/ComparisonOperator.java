package com.gotreaux.aoc.puzzles.year2017.day8;

import java.util.Arrays;

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

    static ComparisonOperator of(String label) {
        return Arrays.stream(values())
                .filter(comparisonOperator -> comparisonOperator.getLabel().equals(label))
                .findFirst()
                .orElseThrow();
    }
}
