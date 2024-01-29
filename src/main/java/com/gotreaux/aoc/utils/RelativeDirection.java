package com.gotreaux.aoc.utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum RelativeDirection {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

    private final char label;

    RelativeDirection(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public static RelativeDirection fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(instruction -> instruction.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }
}
