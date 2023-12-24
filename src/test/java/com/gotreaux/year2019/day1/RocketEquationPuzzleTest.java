package com.gotreaux.year2019.day1;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RocketEquationPuzzleTest {
    @Test
    void fuelRequirementOf12() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("12");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf14() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("14");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf1969() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1969");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(654L, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf100756() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("100756");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(33583L, puzzle.getPartOne());
    }

    @Test
    void additionalFuelRequirementOf12() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("12");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf14() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("14");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf1969() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1969");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(966L, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf100756() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("100756");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        assertEquals(50346L, puzzle.getPartTwo());
    }
}