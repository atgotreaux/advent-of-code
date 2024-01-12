package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(6440, output.partOne());
    }

    @Test
    void jokerHands() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(5905, output.partTwo());
    }
}
