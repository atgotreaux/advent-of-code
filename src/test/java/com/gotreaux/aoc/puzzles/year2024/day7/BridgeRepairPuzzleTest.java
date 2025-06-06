package com.gotreaux.aoc.puzzles.year2024.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class BridgeRepairPuzzleTest {

    @Test
    void totalCalibrationResult() {
        InputReader inputReader = new ResourceInputReader<>(BridgeRepairPuzzle.class);

        var puzzle = new BridgeRepairPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3749L, output.partOne());
    }

    @Test
    void totalCalibrationResultWithConcatenation() {
        InputReader inputReader = new ResourceInputReader<>(BridgeRepairPuzzle.class);

        var puzzle = new BridgeRepairPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(11387L, output.partTwo());
    }
}
