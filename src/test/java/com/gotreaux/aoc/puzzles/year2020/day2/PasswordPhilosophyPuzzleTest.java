package com.gotreaux.aoc.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class PasswordPhilosophyPuzzleTest {
    @Test
    void sumOfValidOccurrencesInRange() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(2, output.partOne());
    }

    @Test
    void sumOfValidPositions() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(1, output.partTwo());
    }
}
