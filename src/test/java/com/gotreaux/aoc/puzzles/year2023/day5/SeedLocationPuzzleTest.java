package com.gotreaux.aoc.puzzles.year2023.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SeedLocationPuzzleTest {
    @Test
    void lowestLocationNumber() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(35L, output.partOne());
    }

    @Test
    void lowestLocationNumberInRange() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SeedLocationPuzzle.class);

        SeedLocationPuzzle puzzle = new SeedLocationPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(46L, output.partTwo());
    }
}
