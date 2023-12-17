package com.gotreaux.year2023.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        puzzle.prepare();

        assertEquals(288, puzzle.getPartOne());
    }

    @Test
    void kerningRace() throws Exception {
        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        puzzle.prepare();

        assertEquals(71503, puzzle.getPartTwo());
    }
}