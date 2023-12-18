package com.gotreaux.year2021.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() throws Exception {
        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        puzzle.prepare();

        assertEquals(7, puzzle.getPartOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() throws Exception {
        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        puzzle.prepare();

        assertEquals(5, puzzle.getPartTwo());
    }
}