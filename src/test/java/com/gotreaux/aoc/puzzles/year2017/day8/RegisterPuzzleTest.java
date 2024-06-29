package com.gotreaux.aoc.puzzles.year2017.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RegisterPuzzleTest {
    @Test
    void largestRegisterValue() throws Exception {
        InputProvider inputProvider = new FileInputProvider(RegisterPuzzle.class);

        RegisterPuzzle puzzle = new RegisterPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(1, output.partOne());
    }

    @Test
    void maxRegisterValue() throws Exception {
        InputProvider inputProvider = new FileInputProvider(RegisterPuzzle.class);

        RegisterPuzzle puzzle = new RegisterPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(10, output.partTwo());
    }
}
