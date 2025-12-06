package com.gotreaux.aoc.puzzles.year2020.day5;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

public enum Region implements LabeledEnum<Character> {
    FRONT('F'),
    BACK('B'),
    LEFT('L'),
    RIGHT('R');

    private final char label;

    Region(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
