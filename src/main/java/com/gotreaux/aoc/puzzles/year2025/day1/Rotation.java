package com.gotreaux.aoc.puzzles.year2025.day1;

import java.util.Arrays;

enum Rotation {
    LEFT('L'),
    RIGHT('R');

    private final char label;

    Rotation(char label) {
        this.label = label;
    }

    private char getLabel() {
        return label;
    }

    static Rotation of(char label) {
        return Arrays.stream(values())
                .filter(rotation -> rotation.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
