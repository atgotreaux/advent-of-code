package com.gotreaux.aoc.puzzles.year2015.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ActionTest {

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Action.of("X"));
    }

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Action expected) {
        assertEquals(expected, Action.of(line));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", Action.ON),
                Arguments.of("toggle 0,0 through 999,0", Action.TOGGLE),
                Arguments.of("turn off 499,499 through 500,500", Action.OFF));
    }
}
