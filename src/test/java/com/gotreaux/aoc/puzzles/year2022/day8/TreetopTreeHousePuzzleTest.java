package com.gotreaux.aoc.puzzles.year2022.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TreetopTreeHousePuzzleTest {
    @Test
    void treesVisible() throws Exception {
        InputProvider inputProvider = new FileInputProvider(TreetopTreeHousePuzzleTest.class);

        TreetopTreeHousePuzzle puzzle = new TreetopTreeHousePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(21, output.partOne());
    }
}
