package com.gotreaux.aoc.puzzles.year2025.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class PrintingDepartmentPuzzleTest {

    @Test
    void totalAccessiblePaperRolls() {
        InputReader inputReader = new ResourceInputReader<>(PrintingDepartmentPuzzle.class);

        var puzzle = new PrintingDepartmentPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(13L, output.partOne());
    }

    @Test
    void totalRemovablePaperRolls() {
        InputReader inputReader = new ResourceInputReader<>(PrintingDepartmentPuzzle.class);

        var puzzle = new PrintingDepartmentPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(43L, output.partTwo());
    }
}
