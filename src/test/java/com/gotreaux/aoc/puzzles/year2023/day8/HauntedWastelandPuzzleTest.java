package com.gotreaux.aoc.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        InputProvider inputProvider =
                new FileInputProvider<>(HauntedWastelandPuzzle.class, "NoRepeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(2L, output.partOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        InputProvider inputProvider =
                new FileInputProvider<>(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(6L, output.partOne());
    }

    @Test
    void ghostSteps() throws Exception {
        InputProvider inputProvider =
                new FileInputProvider<>(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(6L, output.partTwo());
    }
}
