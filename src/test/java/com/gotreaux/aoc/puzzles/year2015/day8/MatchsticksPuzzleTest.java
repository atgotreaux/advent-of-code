package com.gotreaux.aoc.puzzles.year2015.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class MatchsticksPuzzleTest {
    @Test
    void differenceOfLiteralsAndValues() throws Exception {
        InputProvider inputProvider = new FileInputProvider(MatchsticksPuzzle.class);

        MatchsticksPuzzle puzzle = new MatchsticksPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(12, output.partOne());
    }

    @Test
    void differenceOfEncodedAndLiterals() throws Exception {
        InputProvider inputProvider = new FileInputProvider(MatchsticksPuzzle.class);

        MatchsticksPuzzle puzzle = new MatchsticksPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(19, output.partTwo());
    }
}
