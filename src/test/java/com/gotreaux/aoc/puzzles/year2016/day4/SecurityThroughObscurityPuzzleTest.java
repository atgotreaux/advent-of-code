package com.gotreaux.aoc.puzzles.year2016.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SecurityThroughObscurityPuzzleTest {
    @Test
    void sumOfRealRooms() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SecurityThroughObscurityPuzzle.class);

        SecurityThroughObscurityPuzzle puzzle = new SecurityThroughObscurityPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(1514, output.partOne());
    }
}
