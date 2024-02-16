package com.gotreaux.aoc.puzzles.year2020.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class PassportProcessingPuzzleTest {
    @Test
    void validPassports() throws Exception {
        InputProvider inputProvider = new FileInputProvider(PassportProcessingPuzzle.class);

        PassportProcessingPuzzle puzzle = new PassportProcessingPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(2, output.partOne());
    }
}
