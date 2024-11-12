package com.gotreaux.aoc.puzzles.year2022.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TreetopTreeHousePuzzleTest {
    @Test
    void treesVisible() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TreetopTreeHousePuzzle.class);

        TreetopTreeHousePuzzle puzzle = new TreetopTreeHousePuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(21, output.partOne());
    }

    @Test
    void maxScenicScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TreetopTreeHousePuzzle.class);

        TreetopTreeHousePuzzle puzzle = new TreetopTreeHousePuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(8L, output.partTwo());
    }
}
