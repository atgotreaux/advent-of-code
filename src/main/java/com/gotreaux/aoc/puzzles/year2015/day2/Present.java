package com.gotreaux.aoc.puzzles.year2015.day2;

import java.util.Collections;
import java.util.List;

record Present(int length, int width, int height) {

    static Present of(String line) {
        var parts = line.split("x");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Present dimensions must be 3 parts");
        }

        var length = Integer.parseInt(parts[0]);
        var width = Integer.parseInt(parts[1]);
        var height = Integer.parseInt(parts[2]);

        return new Present(length, width, height);
    }

    Present {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Present dimensions must be greater than 0");
        }
    }

    int getSurfaceArea() {
        return (2 * length * width) + (2 * width * height) + (2 * height * length);
    }

    int getAreaOfSmallestSide() {
        return Collections.min(List.of(length * width, width * height, height * length));
    }

    int getSmallestPerimeter() {
        return Collections.min(
                List.of(2 * (length + width), 2 * (width + height), 2 * (height + length)));
    }

    int getVolume() {
        return length * width * height;
    }
}
