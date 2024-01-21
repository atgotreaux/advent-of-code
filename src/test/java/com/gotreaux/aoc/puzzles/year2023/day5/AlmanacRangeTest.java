package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class AlmanacRangeTest {
    @Test
    void throwsIfAlmanacRangeNonPositive() {
        RandomGenerator generator = RandomGenerator.getDefault();
        int negativeArgumentIndex = generator.nextInt(1, 4);
        long destinationRangeStart =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long sourceRangeStart =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long rangeLength =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(
                IllegalArgumentException.class,
                () -> new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength));
    }

    @Test
    void sourceValueWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long sourceRangeStart = generator.nextLong(0L, 1000L);
        long rangeLength = generator.nextLong(1L, 1000L);

        AlmanacRange range =
                new AlmanacRange(generator.nextLong(1L, 1000L), sourceRangeStart, rangeLength);

        long withinRange =
                generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1L);

        assertTrue(range.isWithinRange(withinRange));
    }

    @Test
    void sourceValueNotWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long sourceRangeStart = generator.nextLong(0L, 1000L);
        long rangeLength = generator.nextLong(1L, 1000L);

        AlmanacRange range =
                new AlmanacRange(generator.nextLong(1L, 1000L), sourceRangeStart, rangeLength);

        long outOfRange = generator.nextLong(0L, sourceRangeStart);

        assertFalse(range.isWithinRange(outOfRange));
    }

    @Test
    void destinationValueWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long destinationRangeStart = generator.nextLong(0L, 1000L);
        long sourceRangeStart = generator.nextLong(0L, 1000L);
        long rangeLength = generator.nextLong(1L, 1000L);

        AlmanacRange range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        long sourceValue =
                generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1L);
        long offset = sourceValue - sourceRangeStart;

        assertEquals(destinationRangeStart + offset, range.getDestinationValue(sourceValue));
    }

    @Test
    void destinationValueNotWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long destinationRangeStart = generator.nextLong(0L, 1000L);
        long sourceRangeStart = generator.nextLong(0L, 1000L);
        long rangeLength = generator.nextLong(1L, 1000L);

        AlmanacRange range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        long outOfRange = generator.nextLong(sourceRangeStart);

        assertEquals(outOfRange, range.getDestinationValue(outOfRange));
    }
}
