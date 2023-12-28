package com.gotreaux.year2015.day4;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdventCoinMiningPuzzleTest {
    @Test
    void testAbcdef() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("abcdef");

        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle(inputProvider);

        assertEquals(609043L, puzzle.getPartOne());
    }

    @Test
    void testPqrstuv() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("pqrstuv");

        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle(inputProvider);

        assertEquals(1048970L, puzzle.getPartOne());
    }
}