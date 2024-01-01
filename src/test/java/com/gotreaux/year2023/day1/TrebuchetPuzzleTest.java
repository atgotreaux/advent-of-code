package com.gotreaux.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle("CalibrationDocument.txt");

        assertEquals(142L, puzzle.getPartOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle("CalibrationDigitsWithLetters.txt");

        assertEquals(281L, puzzle.getPartTwo());
    }
}
