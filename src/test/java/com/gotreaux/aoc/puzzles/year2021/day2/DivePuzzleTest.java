package com.gotreaux.aoc.puzzles.year2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class DivePuzzleTest {
    @Test
    void productOfPosition() throws Exception {
        InputProvider inputProvider = new FileInputProvider(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(150, output.partOne());
    }

    @Test
    void productOfPositionWithAim() throws Exception {
        InputProvider inputProvider = new FileInputProvider(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(900, output.partTwo());
    }
}
