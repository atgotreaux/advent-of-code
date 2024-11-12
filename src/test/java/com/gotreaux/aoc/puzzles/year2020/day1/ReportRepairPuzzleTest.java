package com.gotreaux.aoc.puzzles.year2020.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ReportRepairPuzzleTest {
    @Test
    void productOfTargetSumWithTwoNumbers() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(514579, output.partOne());
    }

    @Test
    void productOfTargetSumWithThreeNumbers() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReportRepairPuzzle.class);

        ReportRepairPuzzle puzzle = new ReportRepairPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(241861950, output.partTwo());
    }
}
