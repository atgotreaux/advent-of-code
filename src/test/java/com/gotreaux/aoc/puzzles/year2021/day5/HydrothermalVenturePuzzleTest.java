package com.gotreaux.aoc.puzzles.year2021.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HydrothermalVenturePuzzleTest {

    @Test
    void overlappingOrthogonalPoints() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HydrothermalVenturePuzzle.class);

        HydrothermalVenturePuzzle puzzle = new HydrothermalVenturePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(5L, output.partOne());
    }

    @Test
    void allOverlappingPoints() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HydrothermalVenturePuzzle.class);

        HydrothermalVenturePuzzle puzzle = new HydrothermalVenturePuzzle();

        PuzzleOutput<Long, Long> output = puzzle.solve(inputReader);

        assertEquals(12L, output.partTwo());
    }
}
