package com.gotreaux.aoc.puzzles.year2017.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ComparisonOperatorTest {
    @ParameterizedTest
    @MethodSource("provideParseComparisonOperator")
    void parseComparisonOperator(String label, ComparisonOperator operator) {
        assertEquals(operator, ComparisonOperator.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> ComparisonOperator.of("X"));
    }

    private static Stream<Arguments> provideParseComparisonOperator() {
        return Stream.of(
                Arguments.of("==", ComparisonOperator.EQ),
                Arguments.of("!=", ComparisonOperator.NE),
                Arguments.of("<", ComparisonOperator.LT),
                Arguments.of(">", ComparisonOperator.GT),
                Arguments.of("<=", ComparisonOperator.LTE),
                Arguments.of(">=", ComparisonOperator.GTE));
    }
}
