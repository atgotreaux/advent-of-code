package com.gotreaux.aoc.puzzles.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(TrebuchetPuzzle.class, "CalibrationDocument.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle(inputProvider);

        assertEquals(142L, puzzle.getPartOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle(inputProvider);

        assertEquals(281L, puzzle.getPartTwo());
    }
}
