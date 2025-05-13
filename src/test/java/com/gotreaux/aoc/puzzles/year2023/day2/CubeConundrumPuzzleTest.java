package com.gotreaux.aoc.puzzles.year2023.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CubeConundrumPuzzle.class);

        var puzzle = new CubeConundrumPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(8, output.partOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(CubeConundrumPuzzle.class);

        var puzzle = new CubeConundrumPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(2286, output.partTwo());
    }
}
