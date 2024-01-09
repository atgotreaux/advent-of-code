package com.gotreaux.aoc.puzzles.year2015.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

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
