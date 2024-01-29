package com.gotreaux.aoc.utils;

import java.awt.Point;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum CardinalDirection {
    NORTH('^'),
    SOUTH('v'),
    EAST('>'),
    WEST('<');

    private final char label;

    CardinalDirection(char label) {
        this.label = label;
    }

    private char getLabel() {
        return label;
    }

    public static CardinalDirection fromLabel(char label) throws NoSuchElementException {
        return Arrays.stream(values())
                .filter(direction -> direction.getLabel() == label)
                .findFirst()
                .orElseThrow();
    }

    public Point move(Point point, int units) {
        return switch (this) {
            case NORTH -> new Point(point.x, point.y + units);
            case SOUTH -> new Point(point.x, point.y - units);
            case EAST -> new Point(point.x + units, point.y);
            case WEST -> new Point(point.x - units, point.y);
        };
    }

    public CardinalDirection turn(RelativeDirection direction) throws IllegalArgumentException {
        if (direction == RelativeDirection.UP || direction == RelativeDirection.DOWN) {
            throw new IllegalArgumentException("Cannot turn up or down");
        }

        return switch (this) {
            case NORTH -> direction == RelativeDirection.RIGHT ? EAST : WEST;
            case SOUTH -> direction == RelativeDirection.RIGHT ? WEST : EAST;
            case EAST -> direction == RelativeDirection.RIGHT ? SOUTH : NORTH;
            case WEST -> direction == RelativeDirection.RIGHT ? NORTH : SOUTH;
        };
    }
}
