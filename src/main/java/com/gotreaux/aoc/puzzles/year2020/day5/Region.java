package com.gotreaux.aoc.puzzles.year2020.day5;

import java.util.Arrays;

public enum Region {
    FRONT('F'),
    BACK('B'),
    LEFT('L'),
    RIGHT('R');

    private final char label;

    Region(char label) {
        this.label = label;
    }

    private char getLabel() {
        return label;
    }

    static Region of(char label) {
        return Arrays.stream(values())
                .filter(region -> region.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
