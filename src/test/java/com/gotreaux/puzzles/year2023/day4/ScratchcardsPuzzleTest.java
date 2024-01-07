package com.gotreaux.puzzles.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.FileInputProvider;
import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle(inputProvider);

        assertEquals(13L, puzzle.getPartOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle(inputProvider);

        assertEquals(30L, puzzle.getPartTwo());
    }
}
