package com.gotreaux.aoc.puzzles.year2021.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class WhaleTreacheryPuzzleTest {
    @Test
    void linearAlignmentFuel() {
        InputReader inputReader = new StringInputReader("16,1,2,0,4,2,7,1,2,14");

        var puzzle = new WhaleTreacheryPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(37, output.partOne());
    }

    @Test
    void consecutiveAlignmentFuel() {
        InputReader inputReader = new StringInputReader("16,1,2,0,4,2,7,1,2,14");

        var puzzle = new WhaleTreacheryPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(168, output.partTwo());
    }
}
