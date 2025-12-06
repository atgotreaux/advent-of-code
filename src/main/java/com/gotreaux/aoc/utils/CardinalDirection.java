package com.gotreaux.aoc.utils;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

public enum CardinalDirection implements LabeledEnum<Character> {
    NORTH('^'),
    SOUTH('v'),
    EAST('>'),
    WEST('<');

    private final char label;

    CardinalDirection(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }

    public CardinalDirection turn(RelativeDirection direction) {
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
