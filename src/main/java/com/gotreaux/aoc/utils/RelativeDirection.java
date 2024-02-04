package com.gotreaux.aoc.utils;

import java.awt.Point;
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

    public Point move(Point point, int units) {
        return switch (this) {
            case UP -> new Point(point.x, point.y + units);
            case DOWN -> new Point(point.x, point.y - units);
            case LEFT -> new Point(point.x - units, point.y);
            case RIGHT -> new Point(point.x + units, point.y);
        };
    }
}
