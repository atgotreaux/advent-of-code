package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class SeedRangeTest {
    @Test
    void throwsIfSeedRangeNonPositive() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long negativeArgumentIndex = generator.nextLong(1, 3);
        long seedStart =
                negativeArgumentIndex == 1L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long rangeLength =
                negativeArgumentIndex == 2L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new SeedRange(seedStart, rangeLength));
    }

    @Test
    void rangeCount() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long seedStart = generator.nextLong(0, 1000);
        long range = generator.nextLong(1, 1000);

        SeedRange seedRange = new SeedRange(seedStart, range);

        assertEquals(range, seedRange.range().count());
    }
}
