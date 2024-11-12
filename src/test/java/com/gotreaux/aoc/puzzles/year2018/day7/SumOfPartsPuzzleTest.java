package com.gotreaux.aoc.puzzles.year2018.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SumOfPartsPuzzleTest {
    @Test
    void stepOrder() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SumOfPartsPuzzle.class);

        SumOfPartsPuzzle puzzle = new SumOfPartsPuzzle();

        PuzzleOutput<String, Integer> output = puzzle.solve(inputReader);

        assertEquals("CABDFE", output.partOne());
    }
}
