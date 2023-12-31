package com.gotreaux.year2023.day5;

import java.util.stream.LongStream;

public record SeedRange(long seedStart, long rangeLength) {
    public SeedRange {
        if (seedStart < 0 || rangeLength <= 0) {
            throw new IllegalArgumentException("Seed range expects positive numbers for range!");
        }
    }

    public LongStream range() {
        return LongStream.range(seedStart, seedStart + rangeLength);
    }
}
