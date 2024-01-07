package com.gotreaux.puzzles.year2023.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class GearRatiosPuzzleTest {
    @Test
    void sumOfParts() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(GearRatiosPuzzle.class);

        GearRatiosPuzzle puzzle = new GearRatiosPuzzle(inputProvider);

        assertEquals(4361, puzzle.getPartOne());
    }

    @Test
    void sumOfGearRatios() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(GearRatiosPuzzle.class);

        GearRatiosPuzzle puzzle = new GearRatiosPuzzle(inputProvider);

        assertEquals(467835, puzzle.getPartTwo());
    }
}
