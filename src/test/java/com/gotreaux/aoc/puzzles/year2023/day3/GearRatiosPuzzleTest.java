package com.gotreaux.aoc.puzzles.year2023.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class GearRatiosPuzzleTest {
    @Test
    void sumOfParts() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(GearRatiosPuzzle.class);

        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(4361, output.partOne());
    }

    @Test
    void sumOfGearRatios() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(GearRatiosPuzzle.class);

        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(467835, output.partTwo());
    }
}
