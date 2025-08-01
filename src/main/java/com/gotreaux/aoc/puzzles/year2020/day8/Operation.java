package com.gotreaux.aoc.puzzles.year2020.day8;

import java.util.Arrays;

enum Operation {
    ACC("acc"),
    JMP("jmp"),
    NOP("nop");

    private final String label;

    Operation(String label) {
        this.label = label;
    }

    private String getLabel() {
        return label;
    }

    static Operation of(String label) {
        return Arrays.stream(values())
                .filter(operation -> operation.getLabel().equals(label))
                .findFirst()
                .orElseThrow();
    }
}
