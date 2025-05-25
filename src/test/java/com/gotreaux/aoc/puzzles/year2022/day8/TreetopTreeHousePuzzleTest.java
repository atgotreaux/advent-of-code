package com.gotreaux.aoc.puzzles.year2022.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TreetopTreeHousePuzzleTest {
    @Test
    void treesVisible() {
        InputReader inputReader = new ResourceInputReader<>(TreetopTreeHousePuzzle.class);

        var puzzle = new TreetopTreeHousePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(21, output.partOne());
    }

    @Test
    void maxScenicScore() {
        InputReader inputReader = new ResourceInputReader<>(TreetopTreeHousePuzzle.class);

        var puzzle = new TreetopTreeHousePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(8L, output.partTwo());
    }
}
