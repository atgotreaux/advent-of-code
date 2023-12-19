package com.gotreaux.year2019.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketEquationPuzzleTest {
    @Test
    void sumOfFuelRequirements() throws Exception {
        RocketEquationPuzzle puzzle = new RocketEquationPuzzle();

        puzzle.prepare();

        assertEquals(34241, puzzle.getPartOne());
    }

    @Test
    void getAdditionalFuelRequirement() throws Exception {
        RocketEquationPuzzle puzzle = new RocketEquationPuzzle();

        puzzle.prepare();

        assertEquals(51316, puzzle.getPartTwo());
    }
}