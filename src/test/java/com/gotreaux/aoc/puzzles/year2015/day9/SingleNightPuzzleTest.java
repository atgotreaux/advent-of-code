package com.gotreaux.aoc.puzzles.year2015.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SingleNightPuzzleTest {
    @Test
    void shortestDistance() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SingleNightPuzzle.class);

        SingleNightPuzzle puzzle = new SingleNightPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(605, output.partOne());
    }

    @Test
    void longestDistance() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SingleNightPuzzle.class);

        SingleNightPuzzle puzzle = new SingleNightPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(982, output.partTwo());
    }
}
