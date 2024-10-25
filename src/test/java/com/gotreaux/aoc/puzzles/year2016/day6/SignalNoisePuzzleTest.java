package com.gotreaux.aoc.puzzles.year2016.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SignalNoisePuzzleTest {
    @Test
    void mostCommonCharMessage() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SignalNoisePuzzle.class);

        SignalNoisePuzzle puzzle = new SignalNoisePuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputProvider);

        assertEquals("easter", output.partOne());
    }

    @Test
    void leastCommonCharMessage() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SignalNoisePuzzle.class);

        SignalNoisePuzzle puzzle = new SignalNoisePuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputProvider);

        assertEquals("advent", output.partTwo());
    }
}
