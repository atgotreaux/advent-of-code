package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class TrianglePuzzleTest {
    @Test
    void validTriangleRow() throws Exception {
        InputReader inputReader = new StringInputReader("5 10 25");

        var puzzle = new TrianglePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(0L, output.partOne());
    }

    @Test
    void validTriangleColumn() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TrianglePuzzle.class);

        var puzzle = new TrianglePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(6L, output.partTwo());
    }
}
