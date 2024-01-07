package com.gotreaux.puzzles.year2023.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle(inputProvider);

        assertEquals(8L, puzzle.getPartOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CubeConundrumPuzzle.class);

        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle(inputProvider);

        assertEquals(2286L, puzzle.getPartTwo());
    }
}
