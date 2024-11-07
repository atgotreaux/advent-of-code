package com.gotreaux.aoc.puzzles.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(13, output.partOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(30, output.partTwo());
    }
}
