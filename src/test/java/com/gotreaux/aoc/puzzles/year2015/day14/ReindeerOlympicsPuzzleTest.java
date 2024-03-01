package com.gotreaux.aoc.puzzles.year2015.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReindeerOlympicsPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideParseReindeer")
    void parseReindeer(String line, Reindeer expected) {
        assertEquals(expected, ReindeerOlympicsPuzzle.parseReindeer(line));
    }

    private static Stream<Arguments> provideParseReindeer() {
        return Stream.of(
                Arguments.of(
                        "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
                        new Reindeer("Comet", 14, 10, 127)),
                Arguments.of(
                        "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.",
                        new Reindeer("Dancer", 16, 11, 162)));
    }
}
