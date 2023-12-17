package com.gotreaux.year2023.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle("CalibrationDocument.txt");

        puzzle.prepare();

        assertEquals(142, puzzle.getPartOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle("CalibrationDigitsWithLetters.txt");

        puzzle.prepare();

        assertEquals(281, puzzle.getPartTwo());
    }
}