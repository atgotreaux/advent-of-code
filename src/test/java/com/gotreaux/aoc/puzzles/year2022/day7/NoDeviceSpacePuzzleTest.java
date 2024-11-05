package com.gotreaux.aoc.puzzles.year2022.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class NoDeviceSpacePuzzleTest {
    @Test
    void sumOfSmallDirectories() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(NoDeviceSpacePuzzle.class);

        NoDeviceSpacePuzzle puzzle = new NoDeviceSpacePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(95437, output.partOne());
    }

    @Test
    void smallestDirectoryToFree() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(NoDeviceSpacePuzzle.class);

        NoDeviceSpacePuzzle puzzle = new NoDeviceSpacePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(24933642, output.partTwo());
    }
}
