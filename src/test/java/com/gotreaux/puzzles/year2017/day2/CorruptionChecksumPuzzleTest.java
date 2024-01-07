package com.gotreaux.puzzles.year2017.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class CorruptionChecksumPuzzleTest {
    @Test
    void checksumDifference() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(CorruptionChecksumPuzzle.class, "ExampleOne.txt");
        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle(inputProvider);

        assertEquals(18L, puzzle.getPartOne());
    }

    @Test
    void checksumDivisibility() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(CorruptionChecksumPuzzle.class, "ExampleTwo.txt");

        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle(inputProvider);

        assertEquals(9L, puzzle.getPartTwo());
    }
}
