package com.gotreaux.aoc.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HauntedWastelandPuzzleTest {
    @Test
    void noRepeatInstructions() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(HauntedWastelandPuzzle.class, "NoRepeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(2L, output.partOne());
    }

    @Test
    void repeatsInstructions() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(6L, output.partOne());
    }

    @Test
    void ghostSteps() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(HauntedWastelandPuzzle.class, "Repeats.txt");

        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(6L, output.partTwo());
    }
}
