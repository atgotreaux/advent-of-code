package com.gotreaux.aoc.puzzles.year2025.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RotationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(char label, Rotation expectedRotation) {
        assertEquals(expectedRotation, Rotation.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Rotation.of('X'));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(Arguments.of('L', Rotation.LEFT), Arguments.of('R', Rotation.RIGHT));
    }
}
