package com.gotreaux.aoc.puzzles.year2022.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CampCleanupPuzzleTest {
    @Test
    void numberOfAssignmentsContained() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(2, output.partOne());
    }

    @Test
    void numberOfAssignmentsOverlapping() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(4, output.partTwo());
    }
}
