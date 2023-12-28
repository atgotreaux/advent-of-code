package com.gotreaux.year2023.day5;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;

class AlmanacRangeTest {
    @Test
    void throwsIfAlmanacRangeNonPositive() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long destinationRangeStart = generator.nextLong();
        long sourceRangeStart = generator.nextLong();
        long rangeLength = -generator.nextLong();

        assertThrows(IllegalArgumentException.class, () -> new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength));
    }

    @Test
    void sourceValueWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long sourceRangeStart = generator.nextLong(1000);
        long rangeLength = generator.nextLong(1000);

        AlmanacRange range = new AlmanacRange(generator.nextLong(), sourceRangeStart, rangeLength);

        long withinRange = generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1);

        assertTrue(range.isWithinRange(withinRange));
    }

    @Test
    void sourceValueNotWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long sourceRangeStart = generator.nextLong(1000);
        long rangeLength = generator.nextLong(1000);

        AlmanacRange range = new AlmanacRange(generator.nextLong(), sourceRangeStart, rangeLength);

        long outOfRange = generator.nextLong(sourceRangeStart);

        assertFalse(range.isWithinRange(outOfRange));
    }

    @Test
    void destinationValueWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long destinationRangeStart = generator.nextLong(1000);
        long sourceRangeStart = generator.nextLong(1000);
        long rangeLength = generator.nextLong(1000);

        AlmanacRange range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        long sourceValue = generator.nextLong(sourceRangeStart, sourceRangeStart + rangeLength - 1);
        long offset = sourceValue - sourceRangeStart;

        assertEquals(destinationRangeStart + offset, range.getDestinationValue(sourceValue));
    }

    @Test
    void destinationValueNotWithinRange() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long destinationRangeStart = generator.nextLong(1000);
        long sourceRangeStart = generator.nextLong(1000);
        long rangeLength = generator.nextLong(1000);

        AlmanacRange range = new AlmanacRange(destinationRangeStart, sourceRangeStart, rangeLength);

        long outOfRange = generator.nextLong(sourceRangeStart);

        assertEquals(outOfRange, range.getDestinationValue(outOfRange));
    }
}