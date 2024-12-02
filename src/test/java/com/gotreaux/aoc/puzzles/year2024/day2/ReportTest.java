package com.gotreaux.aoc.puzzles.year2024.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ReportTest {

    @ParameterizedTest
    @MethodSource("provideIsSafe")
    void isSafe(String line, boolean expected) {
        Report report = Report.from(line);

        assertEquals(expected, report.isSafe());
    }

    @ParameterizedTest
    @MethodSource("provideIsSafeWithTolerance")
    void isSafeWithTolerance(String line, boolean expected) {
        Report report = Report.from(line);

        assertEquals(expected, report.isSafeWithTolerance());
    }

    private static Stream<Arguments> provideIsSafe() {
        return Stream.of(
                Arguments.of("7 6 4 2 1", true),
                Arguments.of("1 2 7 8 9", false),
                Arguments.of("9 7 6 2 1", false),
                Arguments.of("1 3 2 4 5", false),
                Arguments.of("8 6 4 4 1", false),
                Arguments.of("1 3 6 7 9", true));
    }

    private static Stream<Arguments> provideIsSafeWithTolerance() {
        return Stream.of(
                Arguments.of("7 6 4 2 1", true),
                Arguments.of("1 2 7 8 9", false),
                Arguments.of("9 7 6 2 1", false),
                Arguments.of("1 3 2 4 5", true),
                Arguments.of("8 6 4 4 1", true),
                Arguments.of("1 3 6 7 9", true));
    }
}
