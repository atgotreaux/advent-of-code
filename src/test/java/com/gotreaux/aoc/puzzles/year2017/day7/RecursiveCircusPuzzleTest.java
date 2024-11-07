package com.gotreaux.aoc.puzzles.year2017.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RecursiveCircusPuzzleTest {
    @Test
    void nameOfBottomProgram() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(RecursiveCircusPuzzle.class);

        RecursiveCircusPuzzle puzzle = new RecursiveCircusPuzzle();

        PuzzleOutput<String, Integer> output = puzzle.solve(inputProvider);

        assertEquals("tknk", output.partOne());
    }

    @Test
    void weightOfFixedChild() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(RecursiveCircusPuzzle.class);

        RecursiveCircusPuzzle puzzle = new RecursiveCircusPuzzle();

        PuzzleOutput<String, Integer> output = puzzle.solve(inputProvider);

        assertEquals(60, output.partTwo());
    }
}
