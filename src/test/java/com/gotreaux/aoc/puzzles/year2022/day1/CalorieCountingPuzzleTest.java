package com.gotreaux.aoc.puzzles.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle(inputProvider);

        assertEquals(24000L, puzzle.getPartOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle(inputProvider);

        assertEquals(45000L, puzzle.getPartTwo());
    }
}
