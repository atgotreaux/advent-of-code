package com.gotreaux.year2023.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        assertEquals(8L, puzzle.getPartOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        assertEquals(2286L, puzzle.getPartTwo());
    }
}
