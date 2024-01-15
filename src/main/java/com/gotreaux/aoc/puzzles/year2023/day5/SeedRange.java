package com.gotreaux.aoc.puzzles.year2023.day5;

import java.util.stream.LongStream;

record SeedRange(long seedStart, long rangeLength) {
    SeedRange {
        if (seedStart < 0L || rangeLength <= 0L) {
            throw new IllegalArgumentException("Seed range expects positive numbers for range!");
        }
    }

    LongStream range() {
        return LongStream.range(seedStart, seedStart + rangeLength);
    }
}
