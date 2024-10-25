package com.gotreaux.aoc.puzzles.year2023.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        InputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(8, output.partOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        InputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(2286, output.partTwo());
    }
}
