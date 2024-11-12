package com.gotreaux.aoc.puzzles.year2018.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class InventoryManagementSystemPuzzleTest {
    @Test
    void productOfTwoAndThreeLetterOccurrences() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(InventoryManagementSystemPuzzle.class, "ExampleOne.txt");

        InventoryManagementSystemPuzzle puzzle = new InventoryManagementSystemPuzzle();

        PuzzleOutput<Integer, String> output = puzzle.solve(inputReader);

        assertEquals(12, output.partOne());
    }

    @Test
    void commonLettersOfCorrectBoxIds() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(InventoryManagementSystemPuzzle.class, "ExampleTwo.txt");

        InventoryManagementSystemPuzzle puzzle = new InventoryManagementSystemPuzzle();

        PuzzleOutput<Integer, String> output = puzzle.solve(inputReader);

        assertEquals("fgij", output.partTwo());
    }
}
