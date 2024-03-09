package com.gotreaux.aoc.puzzles.year2021.day5;

record Line(int x1, int y1, int x2, int y2) {
    boolean isHorizontal() {
        return x1 == x2;
    }

    boolean isVertical() {
        return y1 == y2;
    }

    int getStartRow() {
        return Math.min(x1, x2);
    }

    int getStartCol() {
        return Math.min(y1, y2);
    }

    int getEndRow() {
        return Math.max(x1, x2);
    }

    int getEndCol() {
        return Math.max(y1, y2);
    }
}
