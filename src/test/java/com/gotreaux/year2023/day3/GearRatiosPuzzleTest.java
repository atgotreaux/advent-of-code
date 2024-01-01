package com.gotreaux.year2023.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GearRatiosPuzzleTest {
    @Test
    void sumOfParts() throws Exception {
        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        assertEquals(4361, puzzle.getPartOne());
    }

    @Test
    void sumOfGearRatios() throws Exception {
        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        assertEquals(467835, puzzle.getPartTwo());
    }
}
