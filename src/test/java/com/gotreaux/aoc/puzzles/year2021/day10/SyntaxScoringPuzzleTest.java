package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SyntaxScoringPuzzleTest {
    @Test
    void totalSyntaxErrorScore() {
        InputReader inputReader = new ResourceInputReader<>(SyntaxScoringPuzzle.class);

        var puzzle = new SyntaxScoringPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(26397, output.partOne());
    }

    @Test
    void middleCompletionScore() {
        InputReader inputReader = new ResourceInputReader<>(SyntaxScoringPuzzle.class);

        var puzzle = new SyntaxScoringPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(288957L, output.partTwo());
    }
}
