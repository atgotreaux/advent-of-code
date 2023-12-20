package com.gotreaux.year2019.day1;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RocketEquationPuzzleTest {
    @Test
    void fuelRequirementOf12() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("12");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(2, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf14() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("14");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(2, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf1969() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1969");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(654, puzzle.getPartOne());
    }

    @Test
    void fuelRequirementOf100756() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("100756");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(33583, puzzle.getPartOne());
    }

    @Test
    void additionalFuelRequirementOf12() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("12");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(2, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf14() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("14");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(2, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf1969() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1969");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(966, puzzle.getPartTwo());
    }

    @Test
    void additionalFuelRequirementOf100756() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("100756");

        RocketEquationPuzzle puzzle = new RocketEquationPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(50346, puzzle.getPartTwo());
    }
}