package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SyntaxScoringPuzzleTest {
    @Test
    void totalSyntaxErrorScore() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(26397, output.partOne());
    }

    @Test
    void middleCompletionScore() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputProvider);

        assertEquals(288957L, output.partTwo());
    }
}
