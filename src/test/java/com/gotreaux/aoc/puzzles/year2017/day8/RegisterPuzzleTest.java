package com.gotreaux.aoc.puzzles.year2017.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RegisterPuzzleTest {
    @Test
    void largestRegisterValue() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(RegisterPuzzle.class);

        RegisterPuzzle puzzle = new RegisterPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(1, output.partOne());
    }

    @Test
    void maxRegisterValue() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(RegisterPuzzle.class);

        RegisterPuzzle puzzle = new RegisterPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(10, output.partTwo());
    }
}
