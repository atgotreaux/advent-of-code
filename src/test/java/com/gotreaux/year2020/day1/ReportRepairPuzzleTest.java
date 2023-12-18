package com.gotreaux.year2020.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        puzzle.prepare();

        assertEquals(514579, puzzle.getPartOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        puzzle.prepare();

        assertEquals(241861950, puzzle.getPartTwo());
    }
}