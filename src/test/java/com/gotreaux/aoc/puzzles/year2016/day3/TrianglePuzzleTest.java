package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrianglePuzzleTest {
    @Test
    void validTriangleRow() throws Exception {
        InputReader inputReader = new StringInputReader("5 10 25");

        TrianglePuzzle puzzle = new TrianglePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(0L, output.partOne());
    }

    @Test
    void validTriangleColumn() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TrianglePuzzle.class);

        TrianglePuzzle puzzle = new TrianglePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(6L, output.partTwo());
    }
}
