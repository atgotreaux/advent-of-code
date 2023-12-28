package com.gotreaux.year2023.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        assertEquals(6440L, puzzle.getPartOne());
    }

    @Test
    void jokerHands() throws Exception {
        CamelCardsPuzzle puzzle = new CamelCardsPuzzle();

        assertEquals(5905L, puzzle.getPartTwo());
    }
}