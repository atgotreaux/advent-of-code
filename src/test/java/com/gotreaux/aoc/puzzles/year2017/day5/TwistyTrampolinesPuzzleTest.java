package com.gotreaux.aoc.puzzles.year2017.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TwistyTrampolinesPuzzleTest {
    @Test
    void incrementedStepsToExit() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(TwistyTrampolinesPuzzle.class);

        TwistyTrampolinesPuzzle puzzle = new TwistyTrampolinesPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(5, output.partOne());
    }

    @Test
    void strangerStepsToExit() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(TwistyTrampolinesPuzzle.class);

        TwistyTrampolinesPuzzle puzzle = new TwistyTrampolinesPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(10, output.partTwo());
    }
}
