package com.gotreaux.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class PasswordPhilosophyPuzzleTest {
    @Test
    void sumOfValidOccurrencesInRange() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle(inputProvider);

        assertEquals(2L, puzzle.getPartOne());
    }

    @Test
    void sumOfValidPositions() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle(inputProvider);

        assertEquals(1L, puzzle.getPartTwo());
    }
}
