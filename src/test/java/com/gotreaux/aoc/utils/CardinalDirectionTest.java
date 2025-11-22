package com.gotreaux.aoc.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CardinalDirectionTest {

    @ParameterizedTest
    @MethodSource("provideParseDirection")
    void parseDirection(char label, CardinalDirection expectedDirection) {
        assertEquals(expectedDirection, CardinalDirection.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> CardinalDirection.of('x'));
    }

    @ParameterizedTest
    @MethodSource("provideFacingOnTurn")
    void facingOnTurn(
            CardinalDirection starting, RelativeDirection instruction, CardinalDirection expected) {
        assertEquals(expected, starting.turn(instruction));
    }

    private static Stream<Arguments> provideParseDirection() {
        return Stream.of(
                Arguments.of('^', CardinalDirection.NORTH),
                Arguments.of('v', CardinalDirection.SOUTH),
                Arguments.of('>', CardinalDirection.EAST),
                Arguments.of('<', CardinalDirection.WEST));
    }

    private static Stream<Arguments> provideFacingOnTurn() {
        return Stream.of(
                Arguments.of(
                        CardinalDirection.NORTH, RelativeDirection.RIGHT, CardinalDirection.EAST),
                Arguments.of(
                        CardinalDirection.NORTH, RelativeDirection.LEFT, CardinalDirection.WEST),
                Arguments.of(
                        CardinalDirection.SOUTH, RelativeDirection.RIGHT, CardinalDirection.WEST),
                Arguments.of(
                        CardinalDirection.SOUTH, RelativeDirection.LEFT, CardinalDirection.EAST),
                Arguments.of(
                        CardinalDirection.EAST, RelativeDirection.RIGHT, CardinalDirection.SOUTH),
                Arguments.of(
                        CardinalDirection.EAST, RelativeDirection.LEFT, CardinalDirection.NORTH),
                Arguments.of(
                        CardinalDirection.WEST, RelativeDirection.RIGHT, CardinalDirection.NORTH),
                Arguments.of(
                        CardinalDirection.WEST, RelativeDirection.LEFT, CardinalDirection.SOUTH));
    }
}
