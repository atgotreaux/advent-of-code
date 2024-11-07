package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(35L, output.partOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(46L, output.partTwo());
    }
}
