package com.gotreaux.puzzles.year2023.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class CamelCardsPuzzleTest {
    @Test
    void jackHands() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle(inputProvider);

        assertEquals(6440L, puzzle.getPartOne());
    }

    @Test
    void jokerHands() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(CamelCardsPuzzle.class);

        CamelCardsPuzzle puzzle = new CamelCardsPuzzle(inputProvider);

        assertEquals(5905L, puzzle.getPartTwo());
    }
}
