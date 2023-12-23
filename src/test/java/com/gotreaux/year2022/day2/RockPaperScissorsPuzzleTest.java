package com.gotreaux.year2022.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        puzzle.prepare();

        assertEquals(15, puzzle.getPartOne());
    }

    @Test
    void outcomeStrategyScore() throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        puzzle.prepare();

        assertEquals(12, puzzle.getPartTwo());
    }
}