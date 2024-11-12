package com.gotreaux.aoc.puzzles.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(13, output.partOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ScratchcardsPuzzle.class);

        ScratchcardsPuzzle puzzle = new ScratchcardsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(30, output.partTwo());
    }
}
