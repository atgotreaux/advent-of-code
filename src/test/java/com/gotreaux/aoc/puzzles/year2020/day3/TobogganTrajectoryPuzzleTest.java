package com.gotreaux.aoc.puzzles.year2020.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TobogganTrajectoryPuzzleTest {
    @Test
    void treesEncountered() {
        InputReader inputReader = new ResourceInputReader<>(TobogganTrajectoryPuzzle.class);

        var puzzle = new TobogganTrajectoryPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(7, output.partOne());
    }

    @Test
    void productOfSlopeCandidates() {
        InputReader inputReader = new ResourceInputReader<>(TobogganTrajectoryPuzzle.class);

        var puzzle = new TobogganTrajectoryPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(336L, output.partTwo());
    }
}
