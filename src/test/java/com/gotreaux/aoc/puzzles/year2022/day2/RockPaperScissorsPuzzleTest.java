package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle(inputProvider);

        assertEquals(15L, puzzle.getPartOne());
    }

    @Test
    void outcomeStrategyScore() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle(inputProvider);

        assertEquals(12L, puzzle.getPartTwo());
    }
}
