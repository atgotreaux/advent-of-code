package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrianglePuzzleTest {
    @Test
    void validTriangleRow() throws Exception {
        InputProvider inputProvider = new StringInputProvider("5 10 25");

        TrianglePuzzle puzzle = new TrianglePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(0L, output.partOne());
    }

    @Test
    void validTriangleColumn() throws Exception {
        InputProvider inputProvider = new FileInputProvider(TrianglePuzzle.class);

        TrianglePuzzle puzzle = new TrianglePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(6L, output.partTwo());
    }
}
