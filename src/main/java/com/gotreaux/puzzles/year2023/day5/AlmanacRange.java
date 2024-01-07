package com.gotreaux.puzzles.year2023.day5;

public record AlmanacRange(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
    public AlmanacRange {
        if (destinationRangeStart < 0 || sourceRangeStart < 0 || rangeLength < 0) {
            throw new IllegalArgumentException(
                    "Almanac range expects non negative numbers for range!");
        }
    }

    public boolean isWithinRange(long sourceValue) {
        return sourceValue >= sourceRangeStart && sourceValue < (sourceRangeStart + rangeLength);
    }

    public long getDestinationValue(long sourceValue) {
        long offset = sourceValue - sourceRangeStart;
        if (offset >= 0 && offset < rangeLength) {
            return destinationRangeStart + offset;
        }
        return sourceValue;
    }
}
