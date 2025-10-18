package com.gotreaux.aoc.puzzles.year2023.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class MirageMaintenancePuzzleTest {

    @Test
    void sumOfForwardExtrapolation() {
        InputReader inputReader = new ResourceInputReader<>(MirageMaintenancePuzzle.class);

        var puzzle = new MirageMaintenancePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(114, output.partOne());
    }

    @Test
    void sumOfBackwardExtrapolation() {
        InputReader inputReader = new ResourceInputReader<>(MirageMaintenancePuzzle.class);

        var puzzle = new MirageMaintenancePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(2, output.partTwo());
    }
}
