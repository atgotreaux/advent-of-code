package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RotateColumnOperationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, RotateColumnOperation expectedOperation) {
        assertEquals(expectedOperation, RotateColumnOperation.of(line));
    }

    @Test
    void throwsIfIncorrectPartLength() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateColumnOperation.of("rotate column x=1 by 1 by 0"));
    }

    @Test
    void throwsIfIncorrectColParts() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateColumnOperation.of("rotate column 1 by 1"));
    }

    @Test
    void throwsIfNegativeColumn() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateColumnOperation.of("rotate column x=-1 by 1"));
    }

    @Test
    void throwsIfNegativeShift() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateColumnOperation.of("rotate column x=1 by -1"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(Arguments.of("rotate column x=1 by 1", new RotateColumnOperation(1, 1)));
    }
}
