package com.gotreaux.aoc.puzzles.year2021.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class GiantSquidPuzzleTest {
    @Test
    void firstWinningScore() throws Exception {
        InputProvider inputProvider = new FileInputProvider(GiantSquidPuzzle.class);

        GiantSquidPuzzle puzzle = new GiantSquidPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(4512, output.partOne());
    }

    @Test
    void lastWinningScore() throws Exception {
        InputProvider inputProvider = new FileInputProvider(GiantSquidPuzzle.class);

        GiantSquidPuzzle puzzle = new GiantSquidPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(1924, output.partTwo());
    }
}
