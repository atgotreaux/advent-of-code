package com.gotreaux.aoc.puzzles.year2020.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CustomCustomsPuzzleTest {
    @Test
    void sumOfAnyoneDeclared() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CustomCustomsPuzzle.class);

        CustomCustomsPuzzle puzzle = new CustomCustomsPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(11L, output.partOne());
    }

    @Test
    void sumOfEveryoneDeclared() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CustomCustomsPuzzle.class);

        CustomCustomsPuzzle puzzle = new CustomCustomsPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(6L, output.partTwo());
    }
}
