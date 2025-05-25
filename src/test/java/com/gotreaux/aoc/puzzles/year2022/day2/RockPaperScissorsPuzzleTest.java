package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class RockPaperScissorsPuzzleTest {
    @Test
    void encryptedStrategyScore() {
        InputReader inputReader = new ResourceInputReader<>(RockPaperScissorsPuzzle.class);

        var puzzle = new RockPaperScissorsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(15, output.partOne());
    }

    @Test
    void outcomeStrategyScore() {
        InputReader inputReader = new ResourceInputReader<>(RockPaperScissorsPuzzle.class);

        var puzzle = new RockPaperScissorsPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(12, output.partTwo());
    }
}
