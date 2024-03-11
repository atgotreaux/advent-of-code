package com.gotreaux.aoc.puzzles.year2021.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class LanternfishPuzzleTest {
    @Test
    void populationOfEightyDays() throws Exception {
        InputProvider inputProvider = new StringInputProvider("3,4,3,1,2");

        LanternfishPuzzle puzzle = new LanternfishPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(5934, output.partOne());
    }
}
