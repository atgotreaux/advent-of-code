package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class SyntaxScoringPuzzleTest {
    @Test
    void totalSyntaxErrorScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(26397, output.partOne());
    }

    @Test
    void middleCompletionScore() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(SyntaxScoringPuzzle.class);

        SyntaxScoringPuzzle puzzle = new SyntaxScoringPuzzle();

        PuzzleOutput<Integer, Long> output = puzzle.solve(inputReader);

        assertEquals(288957L, output.partTwo());
    }
}
