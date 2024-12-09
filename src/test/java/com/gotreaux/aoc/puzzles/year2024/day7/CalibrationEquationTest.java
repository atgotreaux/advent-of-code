package com.gotreaux.aoc.puzzles.year2024.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalibrationEquationTest {

    @ParameterizedTest
    @MethodSource("provideFrom")
    void from(CharSequence line, long expectedResult, List<Long> expectedOperands) {
        CalibrationEquation calibrationEquation = CalibrationEquation.from(line);

        assertEquals(expectedResult, calibrationEquation.result());
        assertEquals(expectedOperands, calibrationEquation.operands());
    }

    @ParameterizedTest
    @MethodSource("provideEvaluate")
    void evaluate(CharSequence line, Iterable<CalibrationOperator> operators, long expected) {
        CalibrationEquation calibrationEquation = CalibrationEquation.from(line);

        assertEquals(expected, calibrationEquation.evaluate(operators));
    }

    private static Stream<Arguments> provideFrom() {
        return Stream.of(
                Arguments.of("190: 10 19", 190L, List.of(10L, 19L)),
                Arguments.of("3267: 81 40 27", 3267L, List.of(81L, 40L, 27L)),
                Arguments.of("83: 17 5", 83L, List.of(17L, 5L)));
    }

    private static Stream<Arguments> provideEvaluate() {
        return Stream.of(
                Arguments.of("190: 10 19", List.of(CalibrationOperator.ADD), 29L),
                Arguments.of("190: 10 19", List.of(CalibrationOperator.MULTIPLY), 190L),
                Arguments.of(
                        "3267: 81 40 27",
                        List.of(CalibrationOperator.ADD, CalibrationOperator.MULTIPLY),
                        3267L),
                Arguments.of(
                        "3267: 81 40 27",
                        List.of(CalibrationOperator.MULTIPLY, CalibrationOperator.ADD),
                        3267L),
                Arguments.of(
                        "292: 11 6 16 20",
                        List.of(
                                CalibrationOperator.ADD,
                                CalibrationOperator.MULTIPLY,
                                CalibrationOperator.ADD),
                        292L),
                Arguments.of("156: 15 6", List.of(CalibrationOperator.CONCATENATE), 156L),
                Arguments.of(
                        "7290: 6 8 6 15",
                        List.of(
                                CalibrationOperator.MULTIPLY,
                                CalibrationOperator.CONCATENATE,
                                CalibrationOperator.MULTIPLY),
                        7290L),
                Arguments.of(
                        "192: 17 8 14",
                        List.of(CalibrationOperator.CONCATENATE, CalibrationOperator.ADD),
                        192L));
    }
}
