package com.gotreaux.aoc.puzzles.year2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(157, output.partOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(70, output.partTwo());
    }
}
