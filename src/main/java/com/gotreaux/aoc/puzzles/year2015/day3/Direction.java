package com.gotreaux.aoc.puzzles.year2015.day3;

import java.awt.Point;
import java.util.Arrays;
import java.util.NoSuchElementException;

enum Direction {
    NORTH('^'),
    SOUTH('v'),
    EAST('>'),
    WEST('<');

    private final char label;

    Direction(char label) {
        this.label = label;
    }

    static Direction fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(direction -> direction.label == label)
                .findFirst()
                .orElseThrow();
    }

    Point move(Point point) {
        return switch (this) {
            case NORTH -> new Point(point.x, point.y + 1);
            case SOUTH -> new Point(point.x, point.y - 1);
            case EAST -> new Point(point.x + 1, point.y);
            case WEST -> new Point(point.x - 1, point.y);
        };
    }
}
