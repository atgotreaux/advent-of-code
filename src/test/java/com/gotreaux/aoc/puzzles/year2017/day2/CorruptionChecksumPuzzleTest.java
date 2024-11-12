package com.gotreaux.aoc.puzzles.year2017.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CorruptionChecksumPuzzleTest {
    @Test
    void checksumDifference() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(CorruptionChecksumPuzzle.class, "ExampleOne.txt");

        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(18, output.partOne());
    }

    @Test
    void checksumDivisibility() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(CorruptionChecksumPuzzle.class, "ExampleTwo.txt");

        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(9, output.partTwo());
    }
}
