package com.gotreaux.puzzles.year2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle(inputProvider);

        assertEquals(514579L, puzzle.getPartOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle(inputProvider);

        assertEquals(241861950L, puzzle.getPartTwo());
    }
}
