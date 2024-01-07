package com.gotreaux.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class InstructionTest {
    @Test
    void parseUp() {
        assertEquals(Instruction.UP, Instruction.fromLabel('U'));
    }

    @Test
    void parseDown() {
        assertEquals(Instruction.DOWN, Instruction.fromLabel('D'));
    }

    @Test
    void parseLeft() {
        assertEquals(Instruction.LEFT, Instruction.fromLabel('L'));
    }

    @Test
    void parseRight() {
        assertEquals(Instruction.RIGHT, Instruction.fromLabel('R'));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Instruction.fromLabel('X'));
    }
}
