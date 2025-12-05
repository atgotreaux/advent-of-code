package com.gotreaux.aoc.puzzles.year2025.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RangeManagerTest {

    @Test
    void addRanges() {
        var rangeManager = new RangeManager();

        rangeManager.addRange(new Range(3, 5));
        rangeManager.addRange(new Range(10, 14));
        rangeManager.addRange(new Range(16, 20));
        rangeManager.addRange(new Range(12, 18));

        var ranges = rangeManager.getRanges();

        assertEquals(2, ranges.size());
        assertTrue(ranges.contains(new Range(3, 5)));
        assertTrue(ranges.contains(new Range(10, 20)));
    }
}
