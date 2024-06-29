package com.gotreaux.aoc.puzzles.year2017.day8;

import java.util.Arrays;
import java.util.NoSuchElementException;

enum Instruction {
    INCREASE("inc"),
    DECREASE("dec");

    private final String label;

    Instruction(String label) {
        this.label = label;
    }

    private String getLabel() {
        return label;
    }

    static Instruction fromLabel(String label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(instruction -> instruction.getLabel().equals(label))
                .findFirst()
                .orElseThrow();
    }
}
