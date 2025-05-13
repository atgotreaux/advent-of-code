package com.gotreaux.aoc.puzzles.year2021.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class BinaryDiagnosticPuzzleTest {
    @Test
    void powerConsumption() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BinaryDiagnosticPuzzle.class);

        var puzzle = new BinaryDiagnosticPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(198, output.partOne());
    }

    @Test
    void lifeSupportRating() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BinaryDiagnosticPuzzle.class);

        var puzzle = new BinaryDiagnosticPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(230, output.partTwo());
    }
}
