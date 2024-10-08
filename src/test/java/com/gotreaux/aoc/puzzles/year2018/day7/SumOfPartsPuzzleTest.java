package com.gotreaux.aoc.puzzles.year2018.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SumOfPartsPuzzleTest {
    @Test
    void stepOrder() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SumOfPartsPuzzle.class);

        SumOfPartsPuzzle puzzle = new SumOfPartsPuzzle(inputProvider);

        PuzzleOutput<String, Integer> output = puzzle.solve();

        assertEquals("CABDFE", output.partOne());
    }
}
