package com.gotreaux.aoc.utils.matrix;

import java.util.EnumSet;

public enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    SOUTHEAST,
    SOUTHWEST,
    NORTHEAST,
    NORTHWEST;

    public static EnumSet<Direction> cardinal() {
        return EnumSet.of(NORTH, SOUTH, EAST, WEST);
    }

    public static EnumSet<Direction> allOf() {
        return EnumSet.allOf(Direction.class);
    }
}
