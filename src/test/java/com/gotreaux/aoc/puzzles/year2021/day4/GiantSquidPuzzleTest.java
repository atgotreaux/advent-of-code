package com.gotreaux.aoc.puzzles.year2021.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class GiantSquidPuzzleTest {
    @Test
    void firstWinningScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(GiantSquidPuzzle.class);

        var puzzle = new GiantSquidPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4512, output.partOne());
    }

    @Test
    void lastWinningScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(GiantSquidPuzzle.class);

        var puzzle = new GiantSquidPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1924, output.partTwo());
    }
}
