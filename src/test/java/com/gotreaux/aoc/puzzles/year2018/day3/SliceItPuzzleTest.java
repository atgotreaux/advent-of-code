package com.gotreaux.aoc.puzzles.year2018.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SliceItPuzzleTest {
    @Test
    void overlapArea() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SliceItPuzzle.class);

        var puzzle = new SliceItPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4L, output.partOne());
    }

    @Test
    void intactClaim() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SliceItPuzzle.class);

        var puzzle = new SliceItPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3, output.partTwo());
    }
}
