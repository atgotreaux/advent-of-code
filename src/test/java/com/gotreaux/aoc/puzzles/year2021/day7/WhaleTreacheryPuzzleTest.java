package com.gotreaux.aoc.puzzles.year2021.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class WhaleTreacheryPuzzleTest {
    @Test
    void linearAlignmentFuel() throws Exception {
        InputProvider inputProvider = new StringInputProvider("16,1,2,0,4,2,7,1,2,14");

        WhaleTreacheryPuzzle puzzle = new WhaleTreacheryPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(37, output.partOne());
    }

    @Test
    void consecutiveAlignmentFuel() throws Exception {
        InputProvider inputProvider = new StringInputProvider("16,1,2,0,4,2,7,1,2,14");

        WhaleTreacheryPuzzle puzzle = new WhaleTreacheryPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(168, output.partTwo());
    }
}
