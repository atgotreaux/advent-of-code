package com.gotreaux.aoc.puzzles.year2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(514579, output.partOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(241861950, output.partTwo());
    }
}
