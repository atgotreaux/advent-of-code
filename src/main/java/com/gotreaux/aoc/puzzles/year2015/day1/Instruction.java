package com.gotreaux.aoc.puzzles.year2015.day1;

import java.util.Arrays;

enum Instruction {
    UP('('),
    DOWN(')');

    private final char label;

    Instruction(char label) {
        this.label = label;
    }

    private char getLabel() {
        return label;
    }

    static Instruction of(char label) {
        return Arrays.stream(values())
                .filter(instruction -> instruction.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
