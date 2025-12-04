package com.gotreaux.aoc.puzzles.year2015.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InstructionTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Instruction expected) {
        assertEquals(expected, Instruction.of(line));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "turn on 0,0 through 999,999", new Instruction(0, 0, 999, 999, Action.ON)),
                Arguments.of(
                        "toggle 0,0 through 999,0", new Instruction(0, 0, 999, 0, Action.TOGGLE)),
                Arguments.of(
                        "turn off 499,499 through 500,500",
                        new Instruction(499, 499, 500, 500, Action.OFF)));
    }

    @Test
    void throwsIfIncorrectPartLength() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Instruction.of("turn on 0,0,0 through 999,999,999"));
    }

    @Test
    void throwsIfNonPositiveCoordinate() {
        var generator = RandomGenerator.getDefault();
        var negativeArgumentIndex = generator.nextInt(1, 5);

        var startRow =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        var startCol =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        var endRow =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        var endCol =
                negativeArgumentIndex == 4
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(
                IllegalArgumentException.class,
                () -> new Instruction(startRow, startCol, endRow, endCol, Action.ON));
    }
}
