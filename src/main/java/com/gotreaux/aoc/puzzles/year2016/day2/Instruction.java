package com.gotreaux.aoc.puzzles.year2016.day2;

import java.util.Arrays;
import java.util.NoSuchElementException;

enum Instruction {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

    private final char label;

    Instruction(char label) {
        this.label = label;
    }

    static Instruction fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(instruction -> instruction.label == label)
                .findFirst()
                .orElseThrow();
    }
}
