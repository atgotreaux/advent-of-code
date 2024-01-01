package com.gotreaux.year2021.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() throws Exception {
        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        assertEquals(7L, puzzle.getPartOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() throws Exception {
        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        assertEquals(5L, puzzle.getPartTwo());
    }
}
