package com.gotreaux.aoc.puzzles.year2017.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class MemoryReallocationPuzzleTest {
    @Test
    void cyclesBeforeDuplicate() {
        InputReader inputReader = new StringInputReader("0 2 7 0");

        var puzzle = new MemoryReallocationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5, output.partOne());
    }

    @Test
    void cycleSize() {
        InputReader inputReader = new StringInputReader("0 2 7 0");

        var puzzle = new MemoryReallocationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }
}
