package com.gotreaux.aoc.puzzles.year2023.day5;

record AlmanacRange(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
    AlmanacRange {
        if (destinationRangeStart < 0L || sourceRangeStart < 0L || rangeLength < 0L) {
            throw new IllegalArgumentException(
                    "Almanac range expects non negative numbers for range!");
        }
    }

    boolean isWithinRange(long sourceValue) {
        return sourceValue >= sourceRangeStart && sourceValue < (sourceRangeStart + rangeLength);
    }

    long getDestinationValue(long sourceValue) {
        long offset = sourceValue - sourceRangeStart;
        if (offset >= 0L && offset < rangeLength) {
            return destinationRangeStart + offset;
        }
        return sourceValue;
    }
}
