package com.gotreaux.aoc.puzzles.year2016.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ChessGamePuzzleTest {
    @Test
    void passwords() throws Exception {
        InputProvider inputProvider = new StringInputProvider("abc");

        ChessGamePuzzle puzzle = new ChessGamePuzzle(inputProvider);

        PuzzleOutput<String, String> output = puzzle.solve();

        assertEquals("18f47a30", output.partOne());
        assertEquals("05ace8e3", output.partTwo());
    }
}
