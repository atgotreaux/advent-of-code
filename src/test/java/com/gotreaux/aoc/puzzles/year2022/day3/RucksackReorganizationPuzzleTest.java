package com.gotreaux.aoc.puzzles.year2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        InputProvider inputProvider =
                new ResourceInputProvider<>(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(157, output.partOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        InputProvider inputProvider =
                new ResourceInputProvider<>(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(70, output.partTwo());
    }
}
