package com.gotreaux.aoc.puzzles.year2022.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TreetopTreeHousePuzzleTest {
    @Test
    void treesVisible() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(TreetopTreeHousePuzzle.class);

        TreetopTreeHousePuzzle puzzle = new TreetopTreeHousePuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(21, output.partOne());
    }

    @Test
    void maxScenicScore() throws Exception {
        InputProvider inputProvider = new FileInputProvider<>(TreetopTreeHousePuzzle.class);

        TreetopTreeHousePuzzle puzzle = new TreetopTreeHousePuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(8L, output.partTwo());
    }
}
