package com.gotreaux.year2016.day1;

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
