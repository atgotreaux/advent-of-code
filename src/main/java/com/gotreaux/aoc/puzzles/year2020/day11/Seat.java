package com.gotreaux.aoc.puzzles.year2020.day11;

import java.util.Arrays;

enum Seat {
    EMPTY('L'),
    OCCUPIED('#'),
    FLOOR('.');

    private final char label;

    Seat(char label) {
        this.label = label;
    }

    char getLabel() {
        return label;
    }

    static Seat of(char label) {
        return Arrays.stream(values())
                .filter(seat -> seat.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
