package com.gotreaux.aoc.puzzles.year2022.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RucksackReorganizationPuzzleTest {
    @Test
    void sumOfCompartmentPriorities() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(157, output.partOne());
    }

    @Test
    void sumOfGroupPriorities() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RucksackReorganizationPuzzle.class);

        RucksackReorganizationPuzzle puzzle = new RucksackReorganizationPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(70, output.partTwo());
    }
}
