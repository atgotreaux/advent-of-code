package com.gotreaux.aoc.puzzles.year2015.day1;

import java.util.Arrays;
import java.util.NoSuchElementException;

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

    static Instruction of(char label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(instruction -> instruction.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
