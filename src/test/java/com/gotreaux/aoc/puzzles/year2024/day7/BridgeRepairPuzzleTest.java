package com.gotreaux.aoc.puzzles.year2024.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BridgeRepairPuzzleTest {

    @Test
    void totalCalibrationResult() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BridgeRepairPuzzle.class);

        BridgeRepairPuzzle puzzle = new BridgeRepairPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(3749L, output.partOne());
    }

    @Test
    void totalCalibrationResultWithConcatenation() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BridgeRepairPuzzle.class);

        BridgeRepairPuzzle puzzle = new BridgeRepairPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(11387L, output.partTwo());
    }
}
