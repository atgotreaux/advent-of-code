package com.gotreaux.aoc.puzzles.year2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class DivePuzzleTest {
    @Test
    void productOfPosition() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(DivePuzzle.class);

        var puzzle = new DivePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(150, output.partOne());
    }

    @Test
    void productOfPositionWithAim() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(DivePuzzle.class);

        var puzzle = new DivePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(900, output.partTwo());
    }
}
