package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(15, output.partOne());
    }

    @Test
    void outcomeStrategyScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(12, output.partTwo());
    }
}
