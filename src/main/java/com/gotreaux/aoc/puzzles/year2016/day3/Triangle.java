package com.gotreaux.aoc.puzzles.year2016.day3;

record Triangle(long a, long b, long c) {
    Triangle {
        if (a <= 0L || b <= 0L || c <= 0L) {
            throw new IllegalArgumentException(
                    "Every side of the triangle must be a positive number!");
        }
    }

    boolean isValid() {
        return a + b > c && a + c > b && b + c > a;
    }
}
