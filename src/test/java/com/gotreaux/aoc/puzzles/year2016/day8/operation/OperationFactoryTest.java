package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationFactoryTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Class<? extends Operation> operationClass) {
        assertEquals(operationClass, OperationFactory.of(line).getClass());
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("rect 3x2", RectOperation.class),
                Arguments.of("rotate column x=1 by 1", RotateColumnOperation.class),
                Arguments.of("rotate row y=0 by 4", RotateRowOperation.class),
                Arguments.of("rotate column x=1 by 1", RotateColumnOperation.class));
    }
}
