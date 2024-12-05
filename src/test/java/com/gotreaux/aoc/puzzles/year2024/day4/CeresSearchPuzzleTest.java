package com.gotreaux.aoc.puzzles.year2024.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CeresSearchPuzzleTest {

    @Test
    void xmasAppearances() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CeresSearchPuzzle.class);

        CeresSearchPuzzle puzzle = new CeresSearchPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(18, output.partOne());
    }

    @Test
    void x_masAppearances() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CeresSearchPuzzle.class);

        CeresSearchPuzzle puzzle = new CeresSearchPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(9, output.partTwo());
    }
}
