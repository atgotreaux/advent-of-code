package com.gotreaux.aoc.puzzles.year2020.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TobogganTrajectoryPuzzleTest {
    @Test
    void treesEncountered() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(7, output.partOne());
    }

    @Test
    void productOfSlopeCandidates() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TobogganTrajectoryPuzzle.class);

        TobogganTrajectoryPuzzle puzzle = new TobogganTrajectoryPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(336L, output.partTwo());
    }
}
