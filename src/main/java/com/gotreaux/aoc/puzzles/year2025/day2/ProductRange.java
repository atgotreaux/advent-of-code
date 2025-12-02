package com.gotreaux.aoc.puzzles.year2025.day2;

import java.util.Collection;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

record ProductRange(long startId, long endId) {

    static ProductRange of(String line) {
        var parts = line.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Product range must be 2 parts");
        }

        var startId = Long.parseLong(parts[0]);
        var endId = Long.parseLong(parts[1]);

        return new ProductRange(startId, endId);
    }

    ProductRange {
        if (startId > endId) {
            throw new IllegalArgumentException("Start ID must be less than end ID");
        }
    }

    Collection<Long> findInvalidIds(LongPredicate predicate) {
        return LongStream.rangeClosed(startId, endId).filter(predicate).boxed().toList();
    }
}
