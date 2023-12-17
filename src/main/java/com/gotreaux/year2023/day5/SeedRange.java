package com.gotreaux.year2023.day5;

import java.util.stream.LongStream;

public record SeedRange(long seedStart, long rangeLength) {
    public LongStream range() {
        return LongStream.range(seedStart, seedStart + rangeLength);
    }
}
