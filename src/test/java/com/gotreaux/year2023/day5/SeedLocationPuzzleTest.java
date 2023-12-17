package com.gotreaux.year2023.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        puzzle.prepare();

        assertEquals(35, puzzle.getPartOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        puzzle.prepare();

        assertEquals(46, puzzle.getPartTwo());
    }
}