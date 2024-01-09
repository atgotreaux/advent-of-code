package com.gotreaux.aoc.puzzles.year2018.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class InventoryManagementSystemPuzzleTest {
    @Test
    void productOfTwoAndThreeLetterOccurrences() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(InventoryManagementSystemPuzzle.class, "ExampleOne.txt");

        InventoryManagementSystemPuzzle puzzle = new InventoryManagementSystemPuzzle(inputProvider);

        assertEquals(12L, puzzle.getPartOne());
    }

    @Test
    void commonLettersOfCorrectBoxIds() throws Exception {
        FileInputProvider inputProvider =
                new FileInputProvider(InventoryManagementSystemPuzzle.class, "ExampleTwo.txt");

        InventoryManagementSystemPuzzle puzzle = new InventoryManagementSystemPuzzle(inputProvider);

        assertEquals("fgij", puzzle.getPartTwo());
    }
}
