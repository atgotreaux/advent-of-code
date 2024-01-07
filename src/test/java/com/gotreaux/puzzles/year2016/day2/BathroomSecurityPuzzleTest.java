package com.gotreaux.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class BathroomSecurityPuzzleTest {
    @Test
    void picturedKeypad() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle(inputProvider);

        assertEquals("1985", puzzle.getPartOne());
    }

    @Test
    void actualBathroomKeypad() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(BathroomSecurityPuzzle.class);

        BathroomSecurityPuzzle puzzle = new BathroomSecurityPuzzle(inputProvider);

        assertEquals("5DB3", puzzle.getPartTwo());
    }
}
