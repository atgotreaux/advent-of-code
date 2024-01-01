package com.gotreaux.year2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DivePuzzleTest {
    @Test
    void productOfPosition() throws Exception {
        DivePuzzle puzzle = new DivePuzzle();

        assertEquals(150, puzzle.getPartOne());
    }

    @Test
    void productOfPositionWithAim() throws Exception {
        DivePuzzle puzzle = new DivePuzzle();

        assertEquals(900, puzzle.getPartTwo());
    }
}
