package com.gotreaux.aoc.puzzles.year2022.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CalorieCountingPuzzleTest {
    @Test
    void testMostCalories() {
        InputReader inputReader = new ResourceInputReader<>(CalorieCountingPuzzle.class);

        var puzzle = new CalorieCountingPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(24000, output.partOne());
    }

    @Test
    void testHighestThreeCalories() {
        InputReader inputReader = new ResourceInputReader<>(CalorieCountingPuzzle.class);

        var puzzle = new CalorieCountingPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(45000, output.partTwo());
    }
}
