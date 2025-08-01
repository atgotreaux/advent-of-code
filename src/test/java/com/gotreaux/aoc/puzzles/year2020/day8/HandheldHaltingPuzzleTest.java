package com.gotreaux.aoc.puzzles.year2020.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class HandheldHaltingPuzzleTest {

    @Test
    void accumulatorValueAtLoopStart() {
        InputReader inputReader = new ResourceInputReader<>(HandheldHaltingPuzzle.class);

        var puzzle = new HandheldHaltingPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5, output.partOne());
    }
}
