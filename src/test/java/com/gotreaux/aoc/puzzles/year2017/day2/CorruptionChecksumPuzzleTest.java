package com.gotreaux.aoc.puzzles.year2017.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CorruptionChecksumPuzzleTest {
    @Test
    void checksumDifference() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(CorruptionChecksumPuzzle.class, "ExampleOne.txt");

        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(18, output.partOne());
    }

    @Test
    void checksumDivisibility() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(CorruptionChecksumPuzzle.class, "ExampleTwo.txt");

        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(9, output.partTwo());
    }
}
