package com.gotreaux.aoc.puzzles.year2022.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SupplyStacksPuzzleTest {
    @Test
    void crateMover9000() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(SupplyStacksPuzzle.class);

        SupplyStacksPuzzle puzzle = new SupplyStacksPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputProvider);

        assertEquals("CMZ", output.partOne());
    }

    @Test
    void crateMover9001() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(SupplyStacksPuzzle.class);

        SupplyStacksPuzzle puzzle = new SupplyStacksPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputProvider);

        assertEquals("MCD", output.partTwo());
    }
}
