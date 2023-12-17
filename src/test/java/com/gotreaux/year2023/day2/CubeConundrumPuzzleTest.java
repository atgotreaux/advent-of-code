package com.gotreaux.year2023.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CubeConundrumPuzzleTest {
    @Test
    void possibleGames() throws Exception {
        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        puzzle.prepare();

        assertEquals(8, puzzle.getPartOne());
    }

    @Test
    void powerOfFewestCubes() throws Exception {
        CubeConundrumPuzzle puzzle = new CubeConundrumPuzzle();

        puzzle.prepare();

        assertEquals(2286, puzzle.getPartTwo());
    }
}