package com.gotreaux.aoc.puzzles.year2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HydrothermalVenturePuzzleTest {
    @Test
    void overlappingPoints() throws Exception {
        InputProvider inputProvider = new FileInputProvider(HydrothermalVenturePuzzle.class);

        HydrothermalVenturePuzzle puzzle = new HydrothermalVenturePuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(5L, output.partOne());
    }
}
