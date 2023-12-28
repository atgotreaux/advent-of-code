package com.gotreaux.year2023.day8;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionTest {
    @Test
    void parseRight() {
        assertEquals(Instruction.RIGHT, Instruction.fromLabel('R'));
    }

    @Test
    void parseLeft() {
        assertEquals(Instruction.LEFT, Instruction.fromLabel('L'));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Instruction.fromLabel('X'));
    }
}