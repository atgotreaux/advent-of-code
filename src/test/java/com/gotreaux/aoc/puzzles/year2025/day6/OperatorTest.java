package com.gotreaux.aoc.puzzles.year2025.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperatorTest {

    @ParameterizedTest
    @MethodSource("provideOperate")
    void operate(Operator operator, Collection<Long> operands, long expected) {
        assertEquals(expected, operator.operate(operands));
    }

    private static Stream<Arguments> provideOperate() {
        return Stream.of(
                Arguments.of(Operator.MULTIPLICATION, List.of(123L, 45L, 6L), 33210L),
                Arguments.of(Operator.ADDITION, List.of(328L, 64L, 98L), 490L),
                Arguments.of(Operator.MULTIPLICATION, List.of(51L, 387L, 215L), 4243455L),
                Arguments.of(Operator.ADDITION, List.of(64L, 23L, 314L), 401L));
    }
}
