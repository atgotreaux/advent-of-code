package com.gotreaux.aoc.puzzles.year2015.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReindeerTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Reindeer expected) {
        assertEquals(expected, Reindeer.of(line));
    }

    @ParameterizedTest
    @MethodSource("provideDistance")
    void distance(Reindeer reindeer, int time, int expectedDistance) {
        assertEquals(expectedDistance, reindeer.getDistance(time));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
                        new Reindeer("Comet", 14, 10, 127)),
                Arguments.of(
                        "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",
                        new Reindeer("Dancer", 16, 11, 162)));
    }

    private static Stream<Arguments> provideDistance() {
        return Stream.of(
                Arguments.of(new Reindeer("Comet", 14, 10, 127), 1000, 1120),
                Arguments.of(new Reindeer("Dancer", 16, 11, 162), 1000, 1056));
    }
}
