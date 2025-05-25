package com.gotreaux.aoc.puzzles.year2022.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CampCleanupPuzzleTest {
    @Test
    void numberOfAssignmentsContained() {
        InputReader inputReader = new ResourceInputReader<>(CampCleanupPuzzle.class);

        var puzzle = new CampCleanupPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(2, output.partOne());
    }

    @Test
    void numberOfAssignmentsOverlapping() {
        InputReader inputReader = new ResourceInputReader<>(CampCleanupPuzzle.class);

        var puzzle = new CampCleanupPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }
}
