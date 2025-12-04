package com.gotreaux.aoc.puzzles.year2025.day4;

import java.util.Arrays;

enum Location {
    PAPER_ROLL('@'),
    REMOVED_ROLL('x'),
    EMPTY('.');

    private final char label;

    Location(char label) {
        this.label = label;
    }

    char getLabel() {
        return label;
    }

    static Location of(char label) {
        return Arrays.stream(values())
                .filter(location -> location.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
