package com.gotreaux.aoc.puzzles.year2025.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LocationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(char label, Location expectedLocation) {
        assertEquals(expectedLocation, Location.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Location.of('A'));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of('@', Location.PAPER_ROLL),
                Arguments.of('x', Location.REMOVED_ROLL),
                Arguments.of('.', Location.EMPTY));
    }
}
