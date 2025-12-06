package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Instruction implements LabeledEnum<Character> {
    UP('('),
    DOWN(')');

    private final char label;

    Instruction(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
