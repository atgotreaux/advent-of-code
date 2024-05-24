package com.gotreaux.aoc.puzzles.year2017.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RecursiveCircusPuzzleTest {
    @Test
    void nameOfBottomProgram() throws Exception {
        InputProvider inputProvider = new FileInputProvider(RecursiveCircusPuzzle.class);

        RecursiveCircusPuzzle puzzle = new RecursiveCircusPuzzle(inputProvider);

        PuzzleOutput<String, Integer> output = puzzle.solve();

        assertEquals("tknk", output.partOne());
    }
}
