package com.gotreaux.aoc.utils.matrix;

import java.util.EnumSet;

public enum Direction {
    NORTH(-1, 0),
    SOUTH(1, 0),
    WEST(0, -1),
    EAST(0, 1),
    SOUTHEAST(1, 1),
    SOUTHWEST(1, -1),
    NORTHEAST(-1, 1),
    NORTHWEST(-1, -1);

    private final int rowOffset;

    private final int colOffset;

    Direction(int rowOffset, int colOffset) {
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public static EnumSet<Direction> cardinal() {
        return EnumSet.of(NORTH, SOUTH, EAST, WEST);
    }

    public static EnumSet<Direction> allOf() {
        return EnumSet.allOf(Direction.class);
    }

    int adjustRow(int row) {
        return row + rowOffset;
    }

    int adjustCol(int col) {
        return col + colOffset;
    }
}
