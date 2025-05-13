package com.gotreaux.aoc.puzzles.year2023.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class GearRatiosPuzzleTest {
    @Test
    void sumOfParts() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(GearRatiosPuzzle.class);

        var puzzle = new GearRatiosPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4361, output.partOne());
    }

    @Test
    void sumOfGearRatios() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(GearRatiosPuzzle.class);

        var puzzle = new GearRatiosPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(467835, output.partTwo());
    }
}
