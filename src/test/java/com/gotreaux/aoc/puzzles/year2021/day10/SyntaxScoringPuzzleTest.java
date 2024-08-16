package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SyntaxScoringPuzzleTest {
    @Test
    void totalSyntaxErrorScore() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle(inputProvider);

        PuzzleOutput<Integer, Long> output = puzzle.solve();

        assertEquals(26397, output.partOne());
    }

    @Test
    void middleCompletionScore() throws Exception {
        InputProvider inputProvider = new FileInputProvider(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle(inputProvider);

        PuzzleOutput<Integer, Long> output = puzzle.solve();

        assertEquals(288957L, output.partTwo());
    }
}
