package com.gotreaux.aoc.puzzles.year2020.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CustomCustomsPuzzleTest {
    @Test
    void sumOfAnyoneDeclared() {
        InputReader inputReader = new ResourceInputReader<>(CustomCustomsPuzzle.class);

        var puzzle = new CustomCustomsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(11L, output.partOne());
    }

    @Test
    void sumOfEveryoneDeclared() {
        InputReader inputReader = new ResourceInputReader<>(CustomCustomsPuzzle.class);

        var puzzle = new CustomCustomsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(6L, output.partTwo());
    }
}
