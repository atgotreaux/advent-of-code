package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Seat implements LabeledEnum<Character> {
    EMPTY('L'),
    OCCUPIED('#'),
    FLOOR('.');

    private final char label;

    Seat(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
