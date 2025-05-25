package com.gotreaux.aoc.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() {
        InputReader inputReader = new ResourceInputReader<>(WaitForItPuzzle.class);

        var puzzle = new WaitForItPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(288L, output.partOne());
    }

    @Test
    void kerningRace() {
        InputReader inputReader = new ResourceInputReader<>(WaitForItPuzzle.class);

        var puzzle = new WaitForItPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(71503L, output.partTwo());
    }
}
