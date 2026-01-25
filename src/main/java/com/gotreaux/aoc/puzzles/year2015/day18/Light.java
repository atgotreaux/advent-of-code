package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Light implements LabeledEnum<Character> {
    ON('#'),
    OFF('.');

    private final char label;

    Light(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
