package com.gotreaux.year2023.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("NoRepeats.txt");

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("Repeats.txt");

        assertEquals(6L, puzzle.getPartOne());
    }

    @Test
    void ghostSteps() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("Repeats.txt");

        assertEquals(6L, puzzle.getPartTwo());
    }
}