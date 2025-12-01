package com.gotreaux.aoc.puzzles.year2025.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InstructionTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Instruction expectedInstruction) {
        assertEquals(expectedInstruction, Instruction.of(line));
    }

    @ParameterizedTest
    @MethodSource("provideRotate")
    void rotate(Instruction instruction, int dial, int expectedDial) {
        assertEquals(expectedDial, instruction.rotate(dial, SecretEntrancePuzzle.DIAL_SIZE));
    }

    @ParameterizedTest
    @MethodSource("provideCountZeroes")
    void countZeroes(Instruction instruction, int dial, int expectedCount) {
        assertEquals(expectedCount, instruction.countZeroes(dial, SecretEntrancePuzzle.DIAL_SIZE));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("L68", new Instruction(Rotation.LEFT, 68)),
                Arguments.of("L30", new Instruction(Rotation.LEFT, 30)),
                Arguments.of("R48", new Instruction(Rotation.RIGHT, 48)),
                Arguments.of("L5", new Instruction(Rotation.LEFT, 5)),
                Arguments.of("R60", new Instruction(Rotation.RIGHT, 60)),
                Arguments.of("L55", new Instruction(Rotation.LEFT, 55)),
                Arguments.of("L1", new Instruction(Rotation.LEFT, 1)),
                Arguments.of("L99", new Instruction(Rotation.LEFT, 99)),
                Arguments.of("R14", new Instruction(Rotation.RIGHT, 14)),
                Arguments.of("L82", new Instruction(Rotation.LEFT, 82)));
    }

    private static Stream<Arguments> provideRotate() {
        return Stream.of(
                Arguments.of(new Instruction(Rotation.LEFT, 68), 50, 82),
                Arguments.of(new Instruction(Rotation.LEFT, 30), 82, 52),
                Arguments.of(new Instruction(Rotation.RIGHT, 48), 52, 0),
                Arguments.of(new Instruction(Rotation.LEFT, 5), 0, 95),
                Arguments.of(new Instruction(Rotation.RIGHT, 60), 95, 55),
                Arguments.of(new Instruction(Rotation.LEFT, 55), 55, 0),
                Arguments.of(new Instruction(Rotation.LEFT, 1), 0, 99),
                Arguments.of(new Instruction(Rotation.LEFT, 99), 99, 0),
                Arguments.of(new Instruction(Rotation.RIGHT, 14), 0, 14),
                Arguments.of(new Instruction(Rotation.LEFT, 82), 14, 32));
    }

    private static Stream<Arguments> provideCountZeroes() {
        return Stream.of(
                Arguments.of(new Instruction(Rotation.LEFT, 68), 50, 1),
                Arguments.of(new Instruction(Rotation.LEFT, 30), 82, 0),
                Arguments.of(new Instruction(Rotation.RIGHT, 48), 52, 1),
                Arguments.of(new Instruction(Rotation.LEFT, 5), 0, 0),
                Arguments.of(new Instruction(Rotation.RIGHT, 60), 95, 1),
                Arguments.of(new Instruction(Rotation.LEFT, 55), 55, 1),
                Arguments.of(new Instruction(Rotation.LEFT, 1), 0, 0),
                Arguments.of(new Instruction(Rotation.LEFT, 99), 99, 1),
                Arguments.of(new Instruction(Rotation.RIGHT, 14), 0, 0),
                Arguments.of(new Instruction(Rotation.LEFT, 82), 14, 1));
    }
}
