package com.gotreaux.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PasswordPhilosophyPuzzleTest {
    @Test
    void sumOfValidOccurrencesInRange() throws Exception {
        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void sumOfValidPositions() throws Exception {
        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        assertEquals(1L, puzzle.getPartTwo());
    }
}
