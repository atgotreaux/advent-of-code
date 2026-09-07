package com.gotreaux.aoc.puzzles.year2015.day19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReplacementTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Replacement expected) {
        assertEquals(expected, Replacement.of(line));
    }

    @Test
    void throwsIfInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> Replacement.of("H =>"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("H => HO", new Replacement("H", "HO")),
                Arguments.of("H => OH", new Replacement("H", "OH")),
                Arguments.of("O => HH", new Replacement("O", "HH")));
    }
}
