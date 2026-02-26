package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RotateRowOperationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, RotateRowOperation expectedOperation) {
        assertEquals(expectedOperation, RotateRowOperation.of(line));
    }

    @Test
    void throwsIfIncorrectPartLength() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRowOperation.of("rotate row y=0 by 4 by 1"));
    }

    @Test
    void throwsIfIncorrectRowParts() {
        assertThrows(
                IllegalArgumentException.class, () -> RotateRowOperation.of("rotate row 0 by 4"));
    }

    @Test
    void throwsIfNegativeRow() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRowOperation.of("rotate row y=-1 by 4"));
    }

    @Test
    void throwsIfNegativeShift() {
        assertThrows(
                IllegalArgumentException.class,
                () -> RotateRowOperation.of("rotate row y=0 by -4"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(Arguments.of("rotate row y=0 by 4", new RotateRowOperation(0, 4)));
    }
}
