package com.gotreaux.aoc.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RaceTest {
    @Test
    void throwsIfNonPositiveRace() {
        var generator = RandomGenerator.getDefault();
        var negativeArgumentIndex = generator.nextInt(1, 3);
        var time =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        var recordDistance =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new Race(time, recordDistance));
    }

    @ParameterizedTest
    @MethodSource("provideWaysToWin")
    void waysToWin(long time, long recordDistance, long expectedCount) {
        var race = new Race(time, recordDistance);

        assertEquals(expectedCount, race.getWaysToWin());
    }

    private static Stream<Arguments> provideWaysToWin() {
        return Stream.of(
                Arguments.of(7L, 9L, 4L), Arguments.of(15L, 40L, 8L), Arguments.of(30L, 200L, 9L));
    }
}
