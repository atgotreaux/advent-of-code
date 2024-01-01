package com.gotreaux.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        assertEquals(288L, puzzle.getPartOne());
    }

    @Test
    void kerningRace() throws Exception {
        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        assertEquals(71503, puzzle.getPartTwo());
    }
}
