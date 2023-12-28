package com.gotreaux.year2015.day2;

import java.util.Arrays;
import java.util.Collections;

public record Present(long length, long width, long height) {
    public Present {
        if (length <= 0 || width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Present dimensions must be greater than 0!");
        }
    }

    public long getSurfaceArea() {
        return (2 * length * width) + (2 * width * height) + (2 * height * length);
    }

    public long getAreaOfSmallestSide() {
        return Collections.min(Arrays.asList(length * width, width * height, height * length));
    }

    public long getSmallestPerimeter() {
        return Collections.min(Arrays.asList(2 * (length + width), 2 * (width + height), 2 * (height + length)));
    }

    public long getVolume() {
        return length * width * height;
    }
}
