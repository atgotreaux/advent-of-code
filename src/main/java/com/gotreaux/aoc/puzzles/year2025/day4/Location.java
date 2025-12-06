package com.gotreaux.aoc.puzzles.year2025.day4;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Location implements LabeledEnum<Character> {
    PAPER_ROLL('@'),
    REMOVED_ROLL('x'),
    EMPTY('.');

    private final char label;

    Location(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
