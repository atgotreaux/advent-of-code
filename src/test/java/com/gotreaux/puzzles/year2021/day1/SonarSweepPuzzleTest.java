package com.gotreaux.puzzles.year2021.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle(inputProvider);

        assertEquals(7L, puzzle.getPartOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(SonarSweepPuzzle.class);

        SonarSweepPuzzle puzzle = new SonarSweepPuzzle(inputProvider);

        assertEquals(5L, puzzle.getPartTwo());
    }
}
