package com.gotreaux.aoc.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(288L, output.partOne());
    }

    @Test
    void kerningRace() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(71503L, output.partTwo());
    }
}
