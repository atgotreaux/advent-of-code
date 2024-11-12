package com.gotreaux.aoc.puzzles.year2016.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SignalNoisePuzzleTest {
    @Test
    void mostCommonCharMessage() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SignalNoisePuzzle.class);

        SignalNoisePuzzle puzzle = new SignalNoisePuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("easter", output.partOne());
    }

    @Test
    void leastCommonCharMessage() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SignalNoisePuzzle.class);

        SignalNoisePuzzle puzzle = new SignalNoisePuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("advent", output.partTwo());
    }
}
