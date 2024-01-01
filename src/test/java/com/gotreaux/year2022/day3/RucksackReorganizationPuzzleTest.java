package com.gotreaux.year2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        assertEquals(157, puzzle.getPartOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        assertEquals(70, puzzle.getPartTwo());
    }
}
