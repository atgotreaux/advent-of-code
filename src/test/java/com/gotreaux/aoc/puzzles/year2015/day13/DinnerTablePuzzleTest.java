package com.gotreaux.aoc.puzzles.year2015.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class DinnerTablePuzzleTest {
    @Test
    void optimalArrangement() throws Exception {
        InputProvider inputProvider = new FileInputProvider(DinnerTablePuzzleTest.class);

        DinnerTablePuzzle puzzle = new DinnerTablePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(330, output.partOne());
    }
}
