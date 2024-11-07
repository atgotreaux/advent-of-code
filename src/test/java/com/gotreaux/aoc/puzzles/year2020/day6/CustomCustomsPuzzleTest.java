package com.gotreaux.aoc.puzzles.year2020.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CustomCustomsPuzzleTest {
    @Test
    void sumOfAnyoneDeclared() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CustomCustomsPuzzle.class);

        CustomCustomsPuzzle puzzle = new CustomCustomsPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(11L, output.partOne());
    }

    @Test
    void sumOfEveryoneDeclared() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CustomCustomsPuzzle.class);

        CustomCustomsPuzzle puzzle = new CustomCustomsPuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputProvider);

        assertEquals(6L, output.partTwo());
    }
}
