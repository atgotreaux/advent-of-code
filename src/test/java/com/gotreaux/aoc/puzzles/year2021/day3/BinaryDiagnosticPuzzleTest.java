package com.gotreaux.aoc.puzzles.year2021.day3;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BinaryDiagnosticPuzzleTest {
    @Test
    void powerConsumption() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(198, output.partOne());
    }

    @Test
    void lifeSupportRating() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(230, output.partTwo());
    }
}
