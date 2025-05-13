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
        var generator = RandomGenerator.getDefault();
        var negativeArgumentIndex = generator.nextInt(1, 4);
        var destinationRangeStart =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        var sourceRangeStart =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        var rangeLength =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(
                IllegalArgumentException.class,
                () -> new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength));
    }

    @Test
    void sourceValueWithinRange() {
        var generator = RandomGenerator.getDefault();

        var sourceRangeStart = generator.nextLong(0L, 1000L);
        var rangeLength = generator.nextLong(1L, 1000L);

        var range = new AlmanacRange(generator.nextLong(1L, 1000L), sourceRangeStart, rangeLength);

        var withinRange = generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1L);

        assertTrue(range.isWithinRange(withinRange));
    }

    @Test
    void sourceValueNotWithinRange() {
        var generator = RandomGenerator.getDefault();

        var sourceRangeStart = generator.nextLong(0L, 1000L);
        var rangeLength = generator.nextLong(1L, 1000L);

        var range = new AlmanacRange(generator.nextLong(1L, 1000L), sourceRangeStart, rangeLength);

        var outOfRange = generator.nextLong(0L, sourceRangeStart);

        assertFalse(range.isWithinRange(outOfRange));
    }

    @Test
    void destinationValueWithinRange() {
        var generator = RandomGenerator.getDefault();

        var destinationRangeStart = generator.nextLong(0L, 1000L);
        var sourceRangeStart = generator.nextLong(0L, 1000L);
        var rangeLength = generator.nextLong(1L, 1000L);

        var range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        var sourceValue = generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1L);
        var offset = sourceValue - sourceRangeStart;

        assertEquals(destinationRangeStart + offset, range.getDestinationValue(sourceValue));
    }

    @Test
    void destinationValueNotWithinRange() {
        var generator = RandomGenerator.getDefault();

        var destinationRangeStart = generator.nextLong(0L, 1000L);
        var sourceRangeStart = generator.nextLong(0L, 1000L);
        var rangeLength = generator.nextLong(1L, 1000L);

        var range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        var outOfRange = generator.nextLong(sourceRangeStart);

        assertEquals(outOfRange, range.getDestinationValue(outOfRange));
    }
}
