package com.gotreaux.aoc.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(288L, output.partOne());
    }

    @Test
    void kerningRace() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(71503L, output.partTwo());
    }
}
