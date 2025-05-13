package com.gotreaux.aoc.puzzles.year2023.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class ScratchcardsPuzzleTest {

    @Test
    void scratchcardPoints() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ScratchcardsPuzzle.class);

        var puzzle = new ScratchcardsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(13, output.partOne());
    }

    @Test
    void totalScratchcards() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ScratchcardsPuzzle.class);

        var puzzle = new ScratchcardsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(30, output.partTwo());
    }
}
