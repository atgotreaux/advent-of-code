package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(15, output.partOne());
    }

    @Test
    void outcomeStrategyScore() throws Exception {
        FileInputProvider inputProvider = new FileInputProvider(RockPaperScissorsPuzzle.class);

        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(12, output.partTwo());
    }
}
