package com.gotreaux.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "NoRepeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        assertEquals(6L, puzzle.getPartOne());
    }

    @Test
    void ghostSteps() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        assertEquals(6L, puzzle.getPartTwo());
    }
}
