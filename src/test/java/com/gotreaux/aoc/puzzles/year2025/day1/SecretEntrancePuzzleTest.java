package com.gotreaux.aoc.puzzles.year2025.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SecretEntrancePuzzleTest {

    @Test
    void timesDialIsZero() {
        InputReader inputReader = new ResourceInputReader<>(SecretEntrancePuzzle.class);

        var puzzle = new SecretEntrancePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(3, output.partOne());
    }

    @Test
    void timesDialPassesZero() {
        InputReader inputReader = new ResourceInputReader<>(SecretEntrancePuzzle.class);

        var puzzle = new SecretEntrancePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(6, output.partTwo());
    }
}
