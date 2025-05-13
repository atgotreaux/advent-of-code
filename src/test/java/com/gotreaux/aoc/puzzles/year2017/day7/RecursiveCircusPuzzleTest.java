package com.gotreaux.aoc.puzzles.year2017.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class RecursiveCircusPuzzleTest {
    @Test
    void nameOfBottomProgram() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RecursiveCircusPuzzle.class);

        var puzzle = new RecursiveCircusPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("tknk", output.partOne());
    }

    @Test
    void weightOfFixedChild() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RecursiveCircusPuzzle.class);

        var puzzle = new RecursiveCircusPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(60, output.partTwo());
    }
}
