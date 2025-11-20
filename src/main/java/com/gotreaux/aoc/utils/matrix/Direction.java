package com.gotreaux.aoc.utils.matrix;

import java.util.function.Function;

public enum Direction {
    NORTH(i -> i - 1, i -> i),
    SOUTH(i -> i + 1, i -> i),
    WEST(i -> i, i -> i - 1),
    EAST(i -> i, i -> i + 1),
    SOUTHEAST(i -> i + 1, i -> i + 1),
    SOUTHWEST(i -> i + 1, i -> i - 1),
    NORTHEAST(i -> i - 1, i -> i + 1),
    NORTHWEST(i -> i - 1, i -> i - 1);

    @SuppressWarnings("ImmutableEnumChecker")
    private final Function<Integer, Integer> adjustRow;

    @SuppressWarnings("ImmutableEnumChecker")
    private final Function<Integer, Integer> adjustCol;

    Direction(Function<Integer, Integer> adjustRow, Function<Integer, Integer> adjustCol) {
        this.adjustRow = adjustRow;
        this.adjustCol = adjustCol;
    }

    public static Direction[] cardinalDirections() {
        return new Direction[] {NORTH, SOUTH, WEST, EAST};
    }

    int adjustRow(int row) {
        return adjustRow.apply(row);
    }

    int adjustCol(int col) {
        return adjustCol.apply(col);
    }
}
