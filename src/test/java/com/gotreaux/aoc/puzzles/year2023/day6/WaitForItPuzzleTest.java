package com.gotreaux.aoc.puzzles.year2023.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class WaitForItPuzzleTest {

    @Test
    void productOfPossibleWins() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(288L, output.partOne());
    }

    @Test
    void kerningRace() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(WaitForItPuzzle.class);

        WaitForItPuzzle puzzle = new WaitForItPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(71503L, output.partTwo());
    }
}
