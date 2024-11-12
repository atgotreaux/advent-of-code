package com.gotreaux.aoc.puzzles.year2016.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SecurityThroughObscurityPuzzleTest {
    @Test
    void sumOfRealRooms() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SecurityThroughObscurityPuzzle.class);

        SecurityThroughObscurityPuzzle puzzle = new SecurityThroughObscurityPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(1514, output.partOne());
    }
}
