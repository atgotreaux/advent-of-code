package com.gotreaux.year2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        puzzle.prepare();

        assertEquals(6440, puzzle.getPartOne());
    }

    @Test
    void jokerHands() throws Exception {
        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        puzzle.prepare();

        assertEquals(5905, puzzle.getPartTwo());
    }
}