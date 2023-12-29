package com.gotreaux.year2021.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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