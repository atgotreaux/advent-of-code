package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import org.junit.jupiter.api.Test;

class TrianglePuzzleTest {
    @Test
    void validTriangleRow() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("5 10 25");

        TrianglePuzzle puzzle = new TrianglePuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void validTriangleColumn() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(TrianglePuzzle.class);

        TrianglePuzzle puzzle = new TrianglePuzzle(inputProvider);

        assertEquals(6L, puzzle.getPartTwo());
    }
}
