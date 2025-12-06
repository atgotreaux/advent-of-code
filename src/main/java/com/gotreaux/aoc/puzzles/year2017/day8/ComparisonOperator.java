package com.gotreaux.aoc.puzzles.year2017.day8;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum ComparisonOperator implements LabeledEnum<String> {
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

    @Override
    public String getLabel() {
        return label;
    }
}
