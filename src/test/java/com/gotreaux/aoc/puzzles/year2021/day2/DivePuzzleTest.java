package com.gotreaux.aoc.puzzles.year2021.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class DivePuzzleTest {
    @Test
    void productOfPosition() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle(inputProvider);

        assertEquals(150, puzzle.getPartOne());
    }

    @Test
    void productOfPositionWithAim() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(DivePuzzle.class);

        DivePuzzle puzzle = new DivePuzzle(inputProvider);

        assertEquals(900, puzzle.getPartTwo());
    }
}
