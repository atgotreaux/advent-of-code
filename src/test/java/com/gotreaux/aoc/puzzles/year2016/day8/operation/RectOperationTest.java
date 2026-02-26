package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RectOperationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, RectOperation expectedOperation) {
        assertEquals(expectedOperation, RectOperation.of(line));
    }

    @Test
    void throwsIfIncorrectPartLength() {
        assertThrows(IllegalArgumentException.class, () -> RectOperation.of("rect 3x2 by 1"));
    }

    @Test
    void throwsIfIncorrectDimensionLength() {
        assertThrows(IllegalArgumentException.class, () -> RectOperation.of("rect 3x2x1"));
    }

    @Test
    void throwsIfNonPositiveDimension() {
        assertThrows(IllegalArgumentException.class, () -> RectOperation.of("rect -3x2"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(Arguments.of("rect 3x2", new RectOperation(3, 2)));
    }
}
