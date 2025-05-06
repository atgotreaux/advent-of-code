package com.gotreaux.aoc.puzzles.year2015.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class DinnerTablePuzzleTest {

    @Test
    void guestTableOptimalArrangement() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(DinnerTablePuzzle.class);

        DinnerTablePuzzle puzzle = new DinnerTablePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(330, output.partOne());
    }
}
