package com.gotreaux.aoc.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class BathroomSecurityPuzzleTest {
    @Test
    void picturedKeypad() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("1985", output.partOne());
    }

    @Test
    void actualBathroomKeypad() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("5DB3", output.partTwo());
    }
}
