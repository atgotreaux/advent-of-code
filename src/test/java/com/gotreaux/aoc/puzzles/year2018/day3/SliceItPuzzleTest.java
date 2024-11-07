package com.gotreaux.aoc.puzzles.year2018.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SliceItPuzzleTest {
    @Test
    void overlapArea() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SliceItPuzzle.class);

        SliceItPuzzle puzzle = new SliceItPuzzle();

        PuzzleOutput<Long, Integer> output = puzzle.solve(inputProvider);

        assertEquals(4L, output.partOne());
    }

    @Test
    void intactClaim() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SliceItPuzzle.class);

        SliceItPuzzle puzzle = new SliceItPuzzle();

        PuzzleOutput<Long, Integer> output = puzzle.solve(inputProvider);

        assertEquals(3, output.partTwo());
    }
}
