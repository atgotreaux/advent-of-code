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

    static Instruction fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(Instruction.values())
                .filter(instruction -> instruction.label == label)
                .findFirst()
                .orElseThrow();
    }
}
