package com.gotreaux.aoc.puzzles.year2016.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InstructionTest {
    @ParameterizedTest
    @MethodSource("provideParseInstruction")
    void parseInstruction(char label, Instruction expectedInstruction) {
        assertEquals(expectedInstruction, Instruction.fromLabel(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Instruction.fromLabel('X'));
    }

    private static Stream<Arguments> provideParseInstruction() {
        return Stream.of(Arguments.of('R', Instruction.RIGHT), Arguments.of('L', Instruction.LEFT));
    }
}
