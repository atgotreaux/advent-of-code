package com.gotreaux.year2023.day5;

public record AlmanacRange(long destinationRangeStart, long sourceRangeStart, long rangeLength) {
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
