package com.gotreaux.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle(inputProvider);

        assertEquals(288L, puzzle.getPartOne());
    }

    @Test
    void kerningRace() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle(inputProvider);

        assertEquals(71503, puzzle.getPartTwo());
    }
}
