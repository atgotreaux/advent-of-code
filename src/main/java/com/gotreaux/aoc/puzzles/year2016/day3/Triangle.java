package com.gotreaux.aoc.puzzles.year2016.day3;

record Triangle(int x, int y, int z) {
    Triangle {
        if (x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException(
                    "Every side of the triangle must be a positive number!");
        }
    }

    boolean isValid() {
        return x + y > z && x + z > y && y + z > x;
    }
}
