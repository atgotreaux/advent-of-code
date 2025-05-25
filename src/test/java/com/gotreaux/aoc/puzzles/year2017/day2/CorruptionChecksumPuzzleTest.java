package com.gotreaux.aoc.puzzles.year2017.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CorruptionChecksumPuzzleTest {
    @Test
    void checksumDifference() {
        InputReader inputReader =
                new ResourceInputReader<>(CorruptionChecksumPuzzle.class, "ExampleOne.txt");

        var puzzle = new CorruptionChecksumPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(18, output.partOne());
    }

    @Test
    void checksumDivisibility() {
        InputReader inputReader =
                new ResourceInputReader<>(CorruptionChecksumPuzzle.class, "ExampleTwo.txt");

        var puzzle = new CorruptionChecksumPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(9, output.partTwo());
    }
}
