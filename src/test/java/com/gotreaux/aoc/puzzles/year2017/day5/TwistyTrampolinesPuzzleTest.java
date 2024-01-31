package com.gotreaux.aoc.puzzles.year2017.day5;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class TwistyTrampolinesPuzzleTest {
    @Test
    void incrementedStepsToExit() throws Exception {
        InputProvider inputProvider = new FileInputProvider(TwistyTrampolinesPuzzle.class);

        TwistyTrampolinesPuzzle puzzle = new TwistyTrampolinesPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(5, output.partOne());
    }

    @Test
    void strangerStepsToExit() throws Exception {
        InputProvider inputProvider = new FileInputProvider(TwistyTrampolinesPuzzle.class);

        TwistyTrampolinesPuzzle puzzle = new TwistyTrampolinesPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(10, output.partTwo());
    }
}
