package com.gotreaux.year2015.day1;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionTest {
    @Test
    void parseUp() {
        assertEquals(Instruction.UP, Instruction.fromLabel('('));
    }

    @Test
    void parseDown() {
        assertEquals(Instruction.DOWN, Instruction.fromLabel(')'));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Instruction.fromLabel('X'));
    }
}