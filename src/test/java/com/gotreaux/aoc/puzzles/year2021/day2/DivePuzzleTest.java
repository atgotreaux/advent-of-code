package com.gotreaux.aoc.puzzles.year2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class DivePuzzleTest {
    @Test
    void productOfPosition() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(150, output.partOne());
    }

    @Test
    void productOfPositionWithAim() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(900, output.partTwo());
    }
}
