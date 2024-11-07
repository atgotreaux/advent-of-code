package com.gotreaux.aoc.puzzles.year2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(514579, output.partOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(241861950, output.partTwo());
    }
}
