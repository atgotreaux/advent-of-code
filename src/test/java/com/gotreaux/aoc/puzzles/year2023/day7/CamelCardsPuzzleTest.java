package com.gotreaux.aoc.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CamelCardsPuzzle.class);

        var puzzle = new CamelCardsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(6440, output.partOne());
    }

    @Test
    void jokerHands() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CamelCardsPuzzle.class);

        var puzzle = new CamelCardsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5905, output.partTwo());
    }
}
