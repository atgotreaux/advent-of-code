package com.gotreaux.aoc.puzzles.year2016.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ChessGamePuzzleTest {
    @Test
    void passwords() throws Exception {
        InputReader inputReader = new StringInputReader("abc");

        ChessGamePuzzle puzzle = new ChessGamePuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("18f47a30", output.partOne());
        assertEquals("05ace8e3", output.partTwo());
    }
}
