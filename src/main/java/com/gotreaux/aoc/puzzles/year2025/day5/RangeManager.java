package com.gotreaux.aoc.puzzles.year2025.day5;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

class RangeManager {

    private final Set<Range> ranges = new TreeSet<>();

    void addRange(Range range) {
        var mergedRange = range;

        var overlapping = ranges.stream().filter(mergedRange::overlaps).findFirst();

        while (overlapping.isPresent()) {
            ranges.remove(overlapping.get());
            mergedRange = mergedRange.merge(overlapping.get());
            overlapping = ranges.stream().filter(mergedRange::overlaps).findFirst();
        }

        ranges.add(mergedRange);
    }

    Set<Range> getRanges() {
        return Collections.unmodifiableSet(ranges);
    }
}
