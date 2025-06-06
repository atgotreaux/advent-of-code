package com.gotreaux.aoc.puzzles.year2015.day6;

import java.util.Arrays;

enum Instruction {
    ON("turn on"),
    OFF("turn off"),
    TOGGLE("toggle");

    private final String label;

    Instruction(String label) {
        this.label = label;
    }

    String getLabel() {
        return label;
    }

    static Instruction of(String line) {
        return Arrays.stream(values())
                .filter(instruction -> line.startsWith(instruction.getLabel()))
                .findFirst()
                .orElseThrow();
    }
}
