package com.gotreaux.aoc.puzzles.year2021.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BinaryDiagnosticPuzzleTest {
    @Test
    void powerConsumption() throws Exception {
        InputProvider inputProvider = new FileInputProvider(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(198, output.partOne());
    }

    @Test
    void lifeSupportRating() throws Exception {
        InputProvider inputProvider = new FileInputProvider(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(230, output.partTwo());
    }
}
