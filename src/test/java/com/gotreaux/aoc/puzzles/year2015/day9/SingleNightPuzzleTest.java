package com.gotreaux.aoc.puzzles.year2015.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SingleNightPuzzleTest {

    @Test
    void shortestDistance() {
        InputReader inputReader = new ResourceInputReader<>(SingleNightPuzzle.class);

        var puzzle = new SingleNightPuzzle();

        assertEquals(605, puzzle.solvePartOne(inputReader));
    }

    @Test
    void longestDistance() {
        InputReader inputReader = new ResourceInputReader<>(SingleNightPuzzle.class);

        var puzzle = new SingleNightPuzzle();

        assertEquals(982, puzzle.solvePartTwo(inputReader));
    }
}
