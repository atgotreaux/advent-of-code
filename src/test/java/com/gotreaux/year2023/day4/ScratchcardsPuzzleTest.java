package com.gotreaux.year2023.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        puzzle.prepare();

        assertEquals(13, puzzle.getPartOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        puzzle.prepare();

        assertEquals(30, puzzle.getPartTwo());
    }
}