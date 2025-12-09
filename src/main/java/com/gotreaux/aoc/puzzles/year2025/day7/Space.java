package com.gotreaux.aoc.puzzles.year2025.day7;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Space implements LabeledEnum<Character> {
    ENTRANCE('S'),
    SPLITTER('^'),
    EMPTY('.');

    private final char label;

    Space(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
