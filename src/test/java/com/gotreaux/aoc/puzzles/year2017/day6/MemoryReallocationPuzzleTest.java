package com.gotreaux.aoc.puzzles.year2017.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class MemoryReallocationPuzzleTest {
    @Test
    void cyclesBeforeDuplicate() throws Exception {
        InputProvider inputProvider = new StringInputProvider("0 2 7 0");

        MemoryReallocationPuzzle puzzle = new MemoryReallocationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(5, output.partOne());
    }

    @Test
    void cycleSize() throws Exception {
        InputProvider inputProvider = new StringInputProvider("0 2 7 0");

        MemoryReallocationPuzzle puzzle = new MemoryReallocationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(4, output.partTwo());
    }
}
