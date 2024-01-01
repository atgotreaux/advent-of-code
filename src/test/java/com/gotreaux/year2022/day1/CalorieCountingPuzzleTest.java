package com.gotreaux.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        assertEquals(24000L, puzzle.getPartOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        assertEquals(45000L, puzzle.getPartTwo());
    }
}
