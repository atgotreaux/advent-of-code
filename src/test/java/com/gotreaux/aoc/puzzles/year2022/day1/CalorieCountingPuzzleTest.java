package com.gotreaux.aoc.puzzles.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(24000, output.partOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(45000, output.partTwo());
    }
}
