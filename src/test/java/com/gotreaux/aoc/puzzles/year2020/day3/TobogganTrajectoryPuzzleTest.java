package com.gotreaux.aoc.puzzles.year2020.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TobogganTrajectoryPuzzleTest {
    @Test
    void treesEncountered() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(7, output.partOne());
    }

    @Test
    void productOfSlopeCandidates() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(336L, output.partTwo());
    }
}
