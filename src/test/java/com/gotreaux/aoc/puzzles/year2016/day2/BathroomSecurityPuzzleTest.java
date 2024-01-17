package com.gotreaux.aoc.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BathroomSecurityPuzzleTest {
    @Test
    void picturedKeypad() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle(inputProvider);

        PuzzleOutput<String, String> output = puzzle.solve();

        assertEquals("1985", output.partOne());
    }

    @Test
    void actualBathroomKeypad() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle(inputProvider);

        PuzzleOutput<String, String> output = puzzle.solve();

        assertEquals("5DB3", output.partTwo());
    }
}
