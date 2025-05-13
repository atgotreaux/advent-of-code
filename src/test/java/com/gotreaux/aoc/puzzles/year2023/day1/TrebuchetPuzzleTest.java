package com.gotreaux.aoc.puzzles.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(TrebuchetPuzzle.class, "CalibrationDocument.txt");

        var puzzle = new TrebuchetPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(142, output.partOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(
                        TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt");

        var puzzle = new TrebuchetPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(281, output.partTwo());
    }
}
