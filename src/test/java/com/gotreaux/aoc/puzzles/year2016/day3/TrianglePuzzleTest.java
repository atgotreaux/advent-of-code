package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrianglePuzzleTest {
    @Test
    void validTriangleRow() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("5 10 25");

        TrianglePuzzle puzzle = new TrianglePuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(0L, output.partOne());
    }

    @Test
    void validTriangleColumn() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(TrianglePuzzle.class);

        TrianglePuzzle puzzle = new TrianglePuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(6L, output.partTwo());
    }
}
