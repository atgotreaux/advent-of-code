package com.gotreaux.aoc.puzzles.year2025.day1;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Rotation implements LabeledEnum<Character> {
    LEFT('L'),
    RIGHT('R');

    private final char label;

    Rotation(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
