package com.gotreaux.aoc.puzzles.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        InputProvider inputProvider =
                new ResourceInputProvider<>(TrebuchetPuzzle.class, "CalibrationDocument.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(142, output.partOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        InputProvider inputProvider =
                new ResourceInputProvider<>(
                        TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(281, output.partTwo());
    }
}
