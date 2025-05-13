package com.gotreaux.aoc.puzzles.year2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReportRepairPuzzle.class);

        var puzzle = new ReportRepairPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(514579, output.partOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReportRepairPuzzle.class);

        var puzzle = new ReportRepairPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(241861950, output.partTwo());
    }
}
