package com.gotreaux.year2023.day6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaceTest {
    @Test
    void throwsIfNonPositiveRace() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long negativeArgumentIndex = generator.nextLong(1, 3);
        long time = negativeArgumentIndex == 1L ? -Math.abs(generator.nextLong()) : Math.abs(generator.nextLong());
        long recordDistance = negativeArgumentIndex == 2L ? -Math.abs(generator.nextLong()) : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new Race(time, recordDistance));
    }

    @ParameterizedTest
    @MethodSource("provideWaysToWin")
    void waysToWin(long time, long recordDistance, long expectedCount) {
        Race race = new Race(time, recordDistance);

        assertEquals(expectedCount, race.getWaysToWin());
    }

    private static Stream<Arguments> provideWaysToWin() {
        return Stream.of(
                Arguments.of(7L, 9L, 4L),
                Arguments.of(15L, 40L, 8L),
                Arguments.of(30L, 200L, 9L)
        );
    }
}