package com.gotreaux.year2020.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        assertEquals(514579L, puzzle.getPartOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        assertEquals(241861950L, puzzle.getPartTwo());
    }
}