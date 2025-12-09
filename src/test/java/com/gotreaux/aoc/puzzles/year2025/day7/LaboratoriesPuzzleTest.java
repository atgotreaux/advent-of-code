package com.gotreaux.aoc.puzzles.year2025.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class LaboratoriesPuzzleTest {

    @Test
    void numberOfBeamSplits() {
        InputReader inputReader = new ResourceInputReader<>(LaboratoriesPuzzle.class);

        var puzzle = new LaboratoriesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(21, output.partOne());
    }

    @Test
    void numberOfTimelines() {
        InputReader inputReader = new ResourceInputReader<>(LaboratoriesPuzzle.class);

        var puzzle = new LaboratoriesPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(40L, output.partTwo());
    }
}
