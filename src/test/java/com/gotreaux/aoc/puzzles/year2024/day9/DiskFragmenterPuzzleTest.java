package com.gotreaux.aoc.puzzles.year2024.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class DiskFragmenterPuzzleTest {

    @Test
    void defragmentBlocks() {
        InputReader inputReader = new StringInputReader("2333133121414131402");

        var puzzle = new DiskFragmenterPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1928L, output.partOne());
    }

    @Test
    void defragmentFiles() {
        InputReader inputReader = new StringInputReader("2333133121414131402");

        var puzzle = new DiskFragmenterPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(2858L, output.partTwo());
    }
}
