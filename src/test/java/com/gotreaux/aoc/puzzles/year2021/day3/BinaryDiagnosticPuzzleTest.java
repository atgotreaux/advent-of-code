package com.gotreaux.aoc.puzzles.year2021.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BinaryDiagnosticPuzzleTest {
    @Test
    void powerConsumption() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(198, output.partOne());
    }

    @Test
    void lifeSupportRating() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BinaryDiagnosticPuzzle.class);

        BinaryDiagnosticPuzzle puzzle = new BinaryDiagnosticPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(230, output.partTwo());
    }
}
