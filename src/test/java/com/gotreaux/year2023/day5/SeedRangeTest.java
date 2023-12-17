package com.gotreaux.year2023.day5;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class SeedRangeTest {
    @Test
    void rangeCount() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long seedStart = generator.nextLong(1000);
        long range = generator.nextLong(1000);

        SeedRange seedRange = new SeedRange(seedStart, range);

        assertEquals(range, seedRange.range().count());
    }
}