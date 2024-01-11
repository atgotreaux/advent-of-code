package com.gotreaux.aoc.puzzles.year2023.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(8, output.partOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(2286, output.partTwo());
    }
}
