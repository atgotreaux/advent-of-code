package com.gotreaux.aoc.puzzles.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(24000, output.partOne());
    }

    @Test
    void testHighestThreeCalories() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CalorieCountingPuzzle.class);

        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(45000, output.partTwo());
    }
}
