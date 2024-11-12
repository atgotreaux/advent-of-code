package com.gotreaux.aoc.puzzles.year2022.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CampCleanupPuzzleTest {
    @Test
    void numberOfAssignmentsContained() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(2, output.partOne());
    }

    @Test
    void numberOfAssignmentsOverlapping() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }
}
