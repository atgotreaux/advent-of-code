package com.gotreaux.aoc.puzzles.year2022.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SupplyStacksPuzzleTest {
    @Test
    void crateMover9000() {
        InputReader inputReader = new ResourceInputReader<>(SupplyStacksPuzzle.class);

        var puzzle = new SupplyStacksPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("CMZ", output.partOne());
    }

    @Test
    void crateMover9001() {
        InputReader inputReader = new ResourceInputReader<>(SupplyStacksPuzzle.class);

        var puzzle = new SupplyStacksPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals("MCD", output.partTwo());
    }
}
