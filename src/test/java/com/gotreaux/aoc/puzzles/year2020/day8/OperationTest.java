package com.gotreaux.aoc.puzzles.year2020.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperationTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String label, Operation expectedOperation) {
        assertEquals(expectedOperation, Operation.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Operation.of("X"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("acc", Operation.ACC),
                Arguments.of("jmp", Operation.JMP),
                Arguments.of("nop", Operation.NOP));
    }
}
