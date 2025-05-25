package com.gotreaux.aoc.puzzles.year2016.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class ChessGamePuzzleTest {
    @Test
    void passwords() {
        InputReader inputReader = new StringInputReader("abc");

        var puzzle = new ChessGamePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("18f47a30", output.partOne());
        assertEquals("05ace8e3", output.partTwo());
    }
}
