package com.gotreaux.aoc.puzzles.year2022.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class NoDeviceSpacePuzzleTest {
    @Test
    void sumOfSmallDirectories() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(NoDeviceSpacePuzzle.class);

        var puzzle = new NoDeviceSpacePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(95437, output.partOne());
    }

    @Test
    void smallestDirectoryToFree() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(NoDeviceSpacePuzzle.class);

        var puzzle = new NoDeviceSpacePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(24933642, output.partTwo());
    }
}
