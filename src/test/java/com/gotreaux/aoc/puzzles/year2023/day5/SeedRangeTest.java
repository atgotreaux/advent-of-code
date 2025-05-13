package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class SeedRangeTest {
    @Test
    void throwsIfSeedRangeNonPositive() {
        var generator = RandomGenerator.getDefault();
        var negativeArgumentIndex = generator.nextInt(1, 3);
        var seedStart =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        var rangeLength =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new SeedRange(seedStart, rangeLength));
    }

    @Test
    void rangeCount() {
        var generator = RandomGenerator.getDefault();

        var seedStart = generator.nextLong(0L, 1000L);
        var range = generator.nextLong(1L, 1000L);

        var seedRange = new SeedRange(seedStart, range);

        assertEquals(range, seedRange.range().count());
    }
}
