package com.gotreaux.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle(inputProvider);

        assertEquals(35L, puzzle.getPartOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle(inputProvider);

        assertEquals(46L, puzzle.getPartTwo());
    }
}
