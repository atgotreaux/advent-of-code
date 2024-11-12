package com.gotreaux.aoc.puzzles.year2023.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TrebuchetPuzzleTest {
    @Test
    void calibrationValue() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(TrebuchetPuzzle.class, "CalibrationDocument.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(142, output.partOne());
    }

    @Test
    void calibrationValueDigitLetters() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(
                        TrebuchetPuzzle.class, "CalibrationDigitsWithLetters.txt");

        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(281, output.partTwo());
    }
}
