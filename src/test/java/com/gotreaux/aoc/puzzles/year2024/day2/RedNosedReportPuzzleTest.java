package com.gotreaux.aoc.puzzles.year2024.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RedNosedReportPuzzleTest {

    @Test
    void numOfSafeReports() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RedNosedReportPuzzle.class);

        RedNosedReportPuzzle puzzle = new RedNosedReportPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(2L, output.partOne());
    }

    @Test
    void numOfSafeReportsWithTolerance() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RedNosedReportPuzzle.class);

        RedNosedReportPuzzle puzzle = new RedNosedReportPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(4L, output.partTwo());
    }
}
