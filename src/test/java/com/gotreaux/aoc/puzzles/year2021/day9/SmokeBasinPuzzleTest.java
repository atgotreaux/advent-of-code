package com.gotreaux.aoc.puzzles.year2021.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SmokeBasinPuzzleTest {
    @Test
    void sumOfRiskLevels() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SmokeBasinPuzzle.class);

        SmokeBasinPuzzle puzzle = new SmokeBasinPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(15, output.partOne());
    }
}
