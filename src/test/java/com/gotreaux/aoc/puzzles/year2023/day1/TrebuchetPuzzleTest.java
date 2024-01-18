package com.gotreaux.aoc.puzzles.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(TrebuchetPuzzle.class, "CalibrationDocument.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(142, output.partOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(281, output.partTwo());
    }
}
