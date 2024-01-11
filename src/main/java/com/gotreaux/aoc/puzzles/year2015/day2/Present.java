package com.gotreaux.aoc.puzzles.year2015.day2;

import java.util.Collections;
import java.util.List;

public record Present(int length, int width, int height) {
    public Present {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Present dimensions must be greater than 0!");
        }
    }

    public int getSurfaceArea() {
        return (2 * length * width) + (2 * width * height) + (2 * height * length);
    }

    public int getAreaOfSmallestSide() {
        return Collections.min(List.of(length * width, width * height, height * length));
    }

    public int getSmallestPerimeter() {
        return Collections.min(
                List.of(2 * (length + width), 2 * (width + height), 2 * (height + length)));
    }

    public int getVolume() {
        return length * width * height;
    }
}
