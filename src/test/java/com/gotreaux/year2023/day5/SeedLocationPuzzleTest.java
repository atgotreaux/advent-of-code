package com.gotreaux.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
