package com.gotreaux.aoc.puzzles.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(24000, output.partOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(45000, output.partTwo());
    }
}
