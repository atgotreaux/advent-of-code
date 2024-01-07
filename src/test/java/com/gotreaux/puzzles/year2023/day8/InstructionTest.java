package com.gotreaux.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

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
