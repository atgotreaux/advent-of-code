package com.gotreaux.year2023.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("NoRepeats.txt");

        puzzle.prepare();

        assertEquals(2, puzzle.getPartOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("Repeats.txt");

        puzzle.prepare();

        assertEquals(6, puzzle.getPartOne());
    }

    @Test
    void ghostSteps() throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle("Repeats.txt");

        puzzle.prepare();

        assertEquals(6, puzzle.getPartTwo());
    }
}