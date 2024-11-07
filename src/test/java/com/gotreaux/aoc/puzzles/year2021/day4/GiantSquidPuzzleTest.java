package com.gotreaux.aoc.puzzles.year2021.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class GiantSquidPuzzleTest {
    @Test
    void firstWinningScore() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(GiantSquidPuzzle.class);

        GiantSquidPuzzle puzzle = new GiantSquidPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(4512, output.partOne());
    }

    @Test
    void lastWinningScore() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(GiantSquidPuzzle.class);

        GiantSquidPuzzle puzzle = new GiantSquidPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(1924, output.partTwo());
    }
}
