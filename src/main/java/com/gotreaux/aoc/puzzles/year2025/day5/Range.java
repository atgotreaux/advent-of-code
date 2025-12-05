package com.gotreaux.aoc.puzzles.year2025.day5;

import java.util.Comparator;

record Range(long start, long end) implements Comparable<Range> {

    static Range of(String line) {
        var parts = line.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Range must be 2 parts");
        }

        var start = Long.parseLong(parts[0]);
        var end = Long.parseLong(parts[1]);

        return new Range(start, end);
    }

    Range {
        if (start > end) {
            throw new IllegalArgumentException("Range must be ordered");
        }
    }

    boolean contains(long value) {
        return value >= start && value <= end;
    }

    boolean overlaps(Range other) {
        return contains(other.start())
                || contains(other.end())
                || other.contains(start)
                || other.contains(end);
    }

    Range merge(Range other) {
        return new Range(Math.min(start, other.start()), Math.max(end, other.end()));
    }

    long size() {
        return end - start + 1;
    }

    @Override
    public int compareTo(Range o) {
        return Comparator.comparingLong(Range::start)
                .thenComparingLong(Range::end)
                .compare(this, o);
    }
}
