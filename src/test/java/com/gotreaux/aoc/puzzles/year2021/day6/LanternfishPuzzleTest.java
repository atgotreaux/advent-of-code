package com.gotreaux.aoc.puzzles.year2021.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import org.junit.jupiter.api.Test;

class LanternfishPuzzleTest {
    @Test
    void populationOf80Days() {
        InputReader inputReader = new StringInputReader("3,4,3,1,2");

        var puzzle = new LanternfishPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5934L, output.partOne());
    }

    @Test
    void populationOf256Days() {
        InputReader inputReader = new StringInputReader("3,4,3,1,2");

        var puzzle = new LanternfishPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(26984457539L, output.partTwo());
    }
}
