package com.gotreaux.aoc.puzzles.year2016.day3;

record Triangle(int a, int b, int c) {
    Triangle {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(
                    "Every side of the triangle must be a positive number!");
        }
    }

    boolean isValid() {
        return a + b > c && a + c > b && b + c > a;
    }
}
