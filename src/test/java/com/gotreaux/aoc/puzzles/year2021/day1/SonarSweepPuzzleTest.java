package com.gotreaux.aoc.puzzles.year2021.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SonarSweepPuzzleTest {
    @Test
    void depthMeasurementIncreaseCount() {
        InputReader inputReader = new ResourceInputReader<>(SonarSweepPuzzle.class);

        var puzzle = new SonarSweepPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(7L, output.partOne());
    }

    @Test
    void depthMeasurementWindowIncreaseCount() {
        InputReader inputReader = new ResourceInputReader<>(SonarSweepPuzzle.class);

        var puzzle = new SonarSweepPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5L, output.partTwo());
    }
}
