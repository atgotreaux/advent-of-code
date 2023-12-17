package com.gotreaux.year2023.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GearRatiosPuzzleTest {
    @Test
    void sumOfParts() throws Exception {
        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        puzzle.prepare();

        assertEquals(4361, puzzle.getPartOne());
    }

    @Test
    void sumOfGearRatios() throws Exception {
        GearRatiosPuzzle puzzle = new GearRatiosPuzzle();

        puzzle.prepare();

        assertEquals(467835, puzzle.getPartTwo());
    }
}