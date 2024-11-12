package com.gotreaux.aoc.puzzles.year2022.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SupplyStacksPuzzleTest {
    @Test
    void crateMover9000() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SupplyStacksPuzzle.class);

        SupplyStacksPuzzle puzzle = new SupplyStacksPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("CMZ", output.partOne());
    }

    @Test
    void crateMover9001() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SupplyStacksPuzzle.class);

        SupplyStacksPuzzle puzzle = new SupplyStacksPuzzle();

        PuzzleOutput<String, String> output = puzzle.solve(inputReader);

        assertEquals("MCD", output.partTwo());
    }
}
