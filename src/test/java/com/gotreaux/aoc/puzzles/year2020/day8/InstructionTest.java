package com.gotreaux.aoc.puzzles.year2020.day8;

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

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("nop +0", new Instruction(Operation.NOP, 0)),
                Arguments.of("acc +1", new Instruction(Operation.ACC, 1)),
                Arguments.of("jmp +4", new Instruction(Operation.JMP, 4)),
                Arguments.of("acc +3", new Instruction(Operation.ACC, 3)),
                Arguments.of("jmp -3", new Instruction(Operation.JMP, -3)),
                Arguments.of("acc -99", new Instruction(Operation.ACC, -99)),
                Arguments.of("acc +1", new Instruction(Operation.ACC, 1)),
                Arguments.of("jmp -4", new Instruction(Operation.JMP, -4)),
                Arguments.of("acc +6", new Instruction(Operation.ACC, 6)));
    }
}
