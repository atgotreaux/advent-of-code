package com.gotreaux.aoc.puzzles.year2021.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(7L, output.partOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(5L, output.partTwo());
    }
}
