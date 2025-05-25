package com.gotreaux.aoc.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class BathroomSecurityPuzzleTest {
    @Test
    void picturedKeypad() {
        InputReader inputReader = new ResourceInputReader<>(BathroomSecurityPuzzle.class);

        var puzzle = new BathroomSecurityPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("1985", output.partOne());
    }

    @Test
    void actualBathroomKeypad() {
        InputReader inputReader = new ResourceInputReader<>(BathroomSecurityPuzzle.class);

        var puzzle = new BathroomSecurityPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("5DB3", output.partTwo());
    }
}
