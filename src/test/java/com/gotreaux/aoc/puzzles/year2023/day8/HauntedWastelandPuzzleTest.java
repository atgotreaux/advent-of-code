package com.gotreaux.aoc.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "NoRepeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(2L, output.partOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(6L, output.partOne());
    }

    @Test
    void ghostSteps() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(6L, output.partTwo());
    }
}
