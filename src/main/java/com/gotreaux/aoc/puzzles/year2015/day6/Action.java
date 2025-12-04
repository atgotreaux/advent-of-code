package com.gotreaux.aoc.puzzles.year2015.day6;

import java.util.Arrays;

enum Action {
    ON("turn on"),
    OFF("turn off"),
    TOGGLE("toggle");

    private final String label;

    Action(String label) {
        this.label = label;
    }

    String getLabel() {
        return label;
    }

    static Action of(String line) {
        return Arrays.stream(values())
                .filter(instruction -> line.startsWith(instruction.getLabel()))
                .findFirst()
                .orElseThrow();
    }
}
