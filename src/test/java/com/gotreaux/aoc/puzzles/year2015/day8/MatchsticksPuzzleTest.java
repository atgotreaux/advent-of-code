package com.gotreaux.aoc.puzzles.year2015.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class MatchsticksPuzzleTest {
    @Test
    void differenceOfLiteralsAndValues() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(MatchsticksPuzzle.class);

        MatchsticksPuzzle puzzle = new MatchsticksPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(12, output.partOne());
    }

    @Test
    void differenceOfEncodedAndLiterals() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(MatchsticksPuzzle.class);

        MatchsticksPuzzle puzzle = new MatchsticksPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(19, output.partTwo());
    }
}
