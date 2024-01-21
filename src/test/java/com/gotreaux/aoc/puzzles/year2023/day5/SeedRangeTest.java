package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class SeedRangeTest {
    @Test
    void throwsIfSeedRangeNonPositive() {
        RandomGenerator generator = RandomGenerator.getDefault();
        int negativeArgumentIndex = generator.nextInt(1, 3);
        long seedStart =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long rangeLength =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new SeedRange(seedStart, rangeLength));
    }

    @Test
    void rangeCount() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long seedStart = generator.nextLong(0L, 1000L);
        long range = generator.nextLong(1L, 1000L);

        SeedRange seedRange = new SeedRange(seedStart, range);

        assertEquals(range, seedRange.range().count());
    }
}
