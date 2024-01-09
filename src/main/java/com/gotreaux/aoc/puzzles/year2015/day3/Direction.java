package com.gotreaux.aoc.puzzles.year2015.day3;

import java.awt.Point;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Direction {
    NORTH('^'),
    SOUTH('v'),
    EAST('>'),
    WEST('<');

    private final char label;

    Direction(char label) {
        this.label = label;
    }

    public static Direction fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.label == label)
                .findFirst()
                .orElseThrow();
    }

    public Point move(Point point) {
        return switch (this) {
            case NORTH -> new Point(point.x, point.y + 1);
            case SOUTH -> new Point(point.x, point.y - 1);
            case EAST -> new Point(point.x + 1, point.y);
            case WEST -> new Point(point.x - 1, point.y);
        };
    }
}
