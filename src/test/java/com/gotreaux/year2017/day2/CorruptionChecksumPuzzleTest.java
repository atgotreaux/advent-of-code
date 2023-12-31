package com.gotreaux.year2017.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CorruptionChecksumPuzzleTest {
    @Test
    void checksumDifference() throws Exception {
        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle("ExampleOne.txt");

        assertEquals(18L, puzzle.getPartOne());
    }

    @Test
    void checksumDivisibility() throws Exception {
        CorruptionChecksumPuzzle puzzle = new CorruptionChecksumPuzzle("ExampleTwo.txt");

        assertEquals(9L, puzzle.getPartTwo());
    }
}