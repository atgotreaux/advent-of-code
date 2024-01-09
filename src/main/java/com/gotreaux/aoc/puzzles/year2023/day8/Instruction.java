package com.gotreaux.aoc.puzzles.year2023.day8;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Instruction {
    RIGHT('R'),
    LEFT('L');

    private final char label;

    Instruction(char label) {
        this.label = label;
    }

    public static Instruction fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(Instruction.values())
                .filter(instruction -> instruction.label == label)
                .findFirst()
                .orElseThrow();
    }
}
