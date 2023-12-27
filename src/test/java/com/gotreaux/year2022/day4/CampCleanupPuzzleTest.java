package com.gotreaux.year2022.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampCleanupPuzzleTest {
    @Test
    void numberOfAssignmentsContained() throws Exception {
        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void numberOfAssignmentsOverlapping() throws Exception {
        CampCleanupPuzzle puzzle = new CampCleanupPuzzle();

        assertEquals(4L, puzzle.getPartTwo());
    }
}