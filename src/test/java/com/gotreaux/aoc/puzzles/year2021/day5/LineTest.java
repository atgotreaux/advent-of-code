package com.gotreaux.aoc.puzzles.year2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineTest {
    @ParameterizedTest
    @MethodSource("provideHorizontal")
    void horizontal(Line line, boolean expected) {
        assertEquals(expected, line.isHorizontal());
    }

    @ParameterizedTest
    @MethodSource("provideVertical")
    void vertical(Line line, boolean expected) {
        assertEquals(expected, line.isVertical());
    }

    @ParameterizedTest
    @MethodSource("providePoints")
    void points(Line line, int expected) {
        assertEquals(expected, line.getPoints().size());
    }

    private static Stream<Arguments> provideHorizontal() {
        return Stream.of(
                Arguments.of(new Line(0, 9, 5, 9), false),
                Arguments.of(new Line(8, 0, 0, 8), false),
                Arguments.of(new Line(7, 0, 7, 4), true));
    }

    private static Stream<Arguments> provideVertical() {
        return Stream.of(
                Arguments.of(new Line(0, 9, 5, 9), true),
                Arguments.of(new Line(8, 0, 0, 8), false),
                Arguments.of(new Line(7, 0, 7, 4), false));
    }

    private static Stream<Arguments> providePoints() {
        return Stream.of(
                Arguments.of(new Line(0, 9, 5, 9), 6),
                Arguments.of(new Line(8, 0, 0, 8), 9),
                Arguments.of(new Line(7, 0, 7, 4), 5));
    }
}
