package com.gotreaux.aoc.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class PasswordPhilosophyPuzzleTest {
    @Test
    void sumOfValidOccurrencesInRange() throws Exception {
        InputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(2, output.partOne());
    }

    @Test
    void sumOfValidPositions() throws Exception {
        InputProvider inputProvider = new FileInputProvider(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(1, output.partTwo());
    }
}
