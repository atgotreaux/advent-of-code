package com.gotreaux.aoc.puzzles.year2016.day8;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

public enum Pixel implements LabeledEnum<Character> {
    OFF('.'),
    ON('#');

    private final char label;

    Pixel(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
