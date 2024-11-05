package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(6440, output.partOne());
    }

    @Test
    void jokerHands() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(5905, output.partTwo());
    }
}
