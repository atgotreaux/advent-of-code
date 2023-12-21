package com.gotreaux.year2015.day4;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventCoinMiningPuzzleTest {
    @Test
    void testAbcdef() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("abcdef");

        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(609043, puzzle.getPartOne());
    }

    @Test
    void testPqrstuv() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("pqrstuv");

        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(1048970, puzzle.getPartOne());
    }
}