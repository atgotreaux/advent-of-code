package com.gotreaux.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BathroomSecurityPuzzleTest {
    @Test
    void picturedKeypad() throws Exception {
        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle();

        assertEquals("1985", puzzle.getPartOne());
    }

    @Test
    void actualBathroomKeypad() throws Exception {
        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle();

        assertEquals("5DB3", puzzle.getPartTwo());
    }
}
