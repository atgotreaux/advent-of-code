package com.gotreaux.year2023.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        assertEquals(35L, puzzle.getPartOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        assertEquals(46L, puzzle.getPartTwo());
    }
}