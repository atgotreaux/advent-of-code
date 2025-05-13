package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SeedLocationPuzzle.class);

        var puzzle = new SeedLocationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(35L, output.partOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SeedLocationPuzzle.class);

        var puzzle = new SeedLocationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(46L, output.partTwo());
    }
}
