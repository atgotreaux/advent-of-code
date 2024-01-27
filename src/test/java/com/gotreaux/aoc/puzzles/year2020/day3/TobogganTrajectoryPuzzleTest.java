package com.gotreaux.aoc.puzzles.year2020.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TobogganTrajectoryPuzzleTest {
    @Test
    void treesEncountered() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle(inputProvider);

        PuzzleOutput<Integer, Long> output = puzzle.solve();

        assertEquals(7, output.partOne());
    }

    @Test
    void productOfSlopeCandidates() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle(inputProvider);

        PuzzleOutput<Integer, Long> output = puzzle.solve();

        assertEquals(336L, output.partTwo());
    }
}
