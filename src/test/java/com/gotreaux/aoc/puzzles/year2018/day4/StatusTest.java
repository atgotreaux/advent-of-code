package com.gotreaux.aoc.puzzles.year2018.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StatusTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(CharSequence line, Status expected) {
        assertEquals(expected, Status.of(line));
    }

    @Test
    void throwsIfCannotMatch() {
        assertThrows(NoSuchElementException.class, () -> Status.of("x"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("Guard #10 begins shift", Status.BEGINS_SHIFT),
                Arguments.of("falls asleep", Status.FALLS_ASLEEP),
                Arguments.of("wakes up", Status.WAKES_UP));
    }
}
