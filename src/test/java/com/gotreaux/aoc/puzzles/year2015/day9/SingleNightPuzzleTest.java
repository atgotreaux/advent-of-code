package com.gotreaux.aoc.puzzles.year2015.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SingleNightPuzzleTest {
    @Test
    void shortestDistance() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SingleNightPuzzle.class);

        SingleNightPuzzle puzzle = new SingleNightPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(605, output.partOne());
    }

    @Test
    void longestDistance() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SingleNightPuzzle.class);

        SingleNightPuzzle puzzle = new SingleNightPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(982, output.partTwo());
    }
}
