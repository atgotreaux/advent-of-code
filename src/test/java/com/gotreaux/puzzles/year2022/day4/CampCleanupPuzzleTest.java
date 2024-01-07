package com.gotreaux.puzzles.year2022.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class CampCleanupPuzzleTest {
    @Test
    void numberOfAssignmentsContained() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void numberOfAssignmentsOverlapping() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CampCleanupPuzzle.class);

        CampCleanupPuzzle puzzle = new CampCleanupPuzzle(inputProvider);

        assertEquals(4L, puzzle.getPartTwo());
    }
}
