package com.gotreaux.aoc.puzzles.year2016.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TwoFactorAuthenticationPuzzleTest {

    @Test
    void numberOfLitPixels() {
        InputReader inputReader = new ResourceInputReader<>(TwoFactorAuthenticationPuzzle.class);

        var puzzle = new TwoFactorAuthenticationPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(6L, output.partOne());
    }
}
