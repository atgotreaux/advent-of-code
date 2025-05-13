package com.gotreaux.aoc.puzzles.year2017.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class RegisterPuzzleTest {
    @Test
    void largestRegisterValue() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RegisterPuzzle.class);

        var puzzle = new RegisterPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1, output.partOne());
    }

    @Test
    void maxRegisterValue() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RegisterPuzzle.class);

        var puzzle = new RegisterPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(10, output.partTwo());
    }
}
