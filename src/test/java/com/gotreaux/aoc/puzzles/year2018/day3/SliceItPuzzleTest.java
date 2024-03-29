package com.gotreaux.aoc.puzzles.year2018.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SliceItPuzzleTest {
    @Test
    void overlapArea() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SliceItPuzzle.class);

        SliceItPuzzle puzzle = new SliceItPuzzle(inputProvider);

        PuzzleOutput<Long, Integer> output = puzzle.solve();

        assertEquals(4L, output.partOne());
    }

    @Test
    void intactClaim() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SliceItPuzzle.class);

        SliceItPuzzle puzzle = new SliceItPuzzle(inputProvider);

        PuzzleOutput<Long, Integer> output = puzzle.solve();

        assertEquals(3, output.partTwo());
    }
}
