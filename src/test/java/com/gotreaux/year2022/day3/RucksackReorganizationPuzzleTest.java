package com.gotreaux.year2022.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        assertEquals(157L, puzzle.getPartOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        assertEquals(70L, puzzle.getPartTwo());
    }
}