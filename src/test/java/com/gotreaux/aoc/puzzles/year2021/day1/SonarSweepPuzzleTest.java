package com.gotreaux.aoc.puzzles.year2021.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(7L, output.partOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(5L, output.partTwo());
    }
}
