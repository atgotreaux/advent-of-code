package com.gotreaux.aoc.puzzles.year2024.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CeresSearchPuzzleTest {

    @Test
    void xmasAppearances() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CeresSearchPuzzle.class);

        var puzzle = new CeresSearchPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(18, output.partOne());
    }

    @Test
    void x_masAppearances() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CeresSearchPuzzle.class);

        var puzzle = new CeresSearchPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(9, output.partTwo());
    }
}
