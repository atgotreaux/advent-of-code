package com.gotreaux.year2022.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        puzzle.prepare();

        assertEquals(24000, puzzle.getPartOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        puzzle.prepare();

        assertEquals(45000, puzzle.getPartTwo());
    }
}