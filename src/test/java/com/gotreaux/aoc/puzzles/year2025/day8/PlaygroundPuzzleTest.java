package com.gotreaux.aoc.puzzles.year2025.day8;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class PlaygroundPuzzleTest {

    @Test
    void productOfLargestCircuits() {
        InputReader inputReader = new ResourceInputReader<>(PlaygroundPuzzle.class);

        var puzzle = new PlaygroundPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(40, output.partOne());
    }

    @Test
    void productOfLastX() {
        InputReader inputReader = new ResourceInputReader<>(PlaygroundPuzzle.class);

        var puzzle = new PlaygroundPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(25272L, output.partTwo());
    }
}
