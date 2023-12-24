package com.gotreaux.year2022.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        assertEquals(15L, puzzle.getPartOne());
    }

    @Test
    void outcomeStrategyScore() throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        assertEquals(12L, puzzle.getPartTwo());
    }
}