package com.gotreaux.aoc.puzzles.year2015.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InstructionTest {
    @ParameterizedTest
    @MethodSource("provideParseLine")
    void parseLine(String line, Instruction expected) {
        assertEquals(expected, Instruction.fromLine(line));
    }

    private static Stream<Arguments> provideParseLine() {
        return Stream.of(
                Arguments.of("turn on 0,0 through 999,999", Instruction.ON),
                Arguments.of("toggle 0,0 through 999,0", Instruction.TOGGLE),
                Arguments.of("turn off 499,499 through 500,500", Instruction.OFF));
    }
}
