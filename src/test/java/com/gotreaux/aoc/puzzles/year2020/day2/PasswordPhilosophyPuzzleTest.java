package com.gotreaux.aoc.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class PasswordPhilosophyPuzzleTest {
    @Test
    void sumOfValidOccurrencesInRange() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(2, output.partOne());
    }

    @Test
    void sumOfValidPositions() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(PasswordPhilosophyPuzzle.class);

        PasswordPhilosophyPuzzle puzzle = new PasswordPhilosophyPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(1, output.partTwo());
    }
}
