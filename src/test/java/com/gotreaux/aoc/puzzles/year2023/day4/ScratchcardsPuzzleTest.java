package com.gotreaux.aoc.puzzles.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(13, output.partOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(30, output.partTwo());
    }
}
