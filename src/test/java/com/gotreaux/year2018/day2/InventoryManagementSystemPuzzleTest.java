package com.gotreaux.year2018.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InventoryManagementSystemPuzzleTest {
    @Test
    void productOfTwoAndThreeLetterOccurrences() throws Exception {
        InventoryManagementSystemPuzzle puzzle =
                new InventoryManagementSystemPuzzle("ExampleOne.txt");

        assertEquals(12L, puzzle.getPartOne());
    }

    @Test
    void commonLettersOfCorrectBoxIds() throws Exception {
        InventoryManagementSystemPuzzle puzzle =
                new InventoryManagementSystemPuzzle("ExampleTwo.txt");

        assertEquals("fgij", puzzle.getPartTwo());
    }
}
