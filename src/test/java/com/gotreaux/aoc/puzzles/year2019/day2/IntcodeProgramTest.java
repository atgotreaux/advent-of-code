package com.gotreaux.aoc.puzzles.year2019.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntcodeProgramTest {
    @ParameterizedTest
    @MethodSource("provideProcess")
    void process(int[] program, int expectedReturn) {
        IntcodeProgram intcodeProgram = new IntcodeProgram(null, null);

        assertEquals(expectedReturn, intcodeProgram.process(program));
    }

    private static Stream<Arguments> provideProcess() {
        return Stream.of(
                Arguments.of(new int[] {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50}, 3500),
                Arguments.of(new int[] {1, 0, 0, 0, 99}, 2),
                Arguments.of(new int[] {2, 3, 0, 3, 99}, 2),
                Arguments.of(new int[] {2, 4, 4, 5, 99, 0}, 2),
                Arguments.of(new int[] {1, 1, 1, 4, 99, 5, 6, 0, 99}, 30));
    }
}
