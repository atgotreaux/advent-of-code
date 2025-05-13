package com.gotreaux.aoc.puzzles.year2017.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class TwistyTrampolinesPuzzleTest {
    @Test
    void incrementedStepsToExit() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TwistyTrampolinesPuzzle.class);

        var puzzle = new TwistyTrampolinesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(5, output.partOne());
    }

    @Test
    void strangerStepsToExit() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(TwistyTrampolinesPuzzle.class);

        var puzzle = new TwistyTrampolinesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(10, output.partTwo());
    }
}
