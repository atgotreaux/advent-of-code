package com.gotreaux.aoc.puzzles.year2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle(inputProvider);

        assertEquals(157, puzzle.getPartOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle(inputProvider);

        assertEquals(70, puzzle.getPartTwo());
    }
}
