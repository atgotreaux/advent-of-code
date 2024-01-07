package com.gotreaux.puzzles.year2016.day2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Instruction {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

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
