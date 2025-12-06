package com.gotreaux.aoc.puzzles.year2025.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TrashCompactorPuzzleTest {

    @Test
    void sumOfHorizontalNumberAnswers() {
        InputReader inputReader = new ResourceInputReader<>(TrashCompactorPuzzle.class);

        var puzzle = new TrashCompactorPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4277556L, output.partOne());
    }

    @Test
    void sumOfVerticalRtlNumberAnswers() {
        InputReader inputReader = new ResourceInputReader<>(TrashCompactorPuzzle.class);

        var puzzle = new TrashCompactorPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3263827L, output.partTwo());
    }
}
