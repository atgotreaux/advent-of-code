package com.gotreaux.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        assertEquals(13L, puzzle.getPartOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        assertEquals(30L, puzzle.getPartTwo());
    }
}
