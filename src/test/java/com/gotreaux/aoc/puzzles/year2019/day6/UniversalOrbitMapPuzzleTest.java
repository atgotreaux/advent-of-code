package com.gotreaux.aoc.puzzles.year2019.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class UniversalOrbitMapPuzzleTest {

    @Test
    void totalDirectAndIndirectOrbits() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(UniversalOrbitMapPuzzle.class, "ExampleOne.txt");

        var puzzle = new UniversalOrbitMapPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(42, output.partOne());
    }

    @Test
    void minimumTransfersRequired() throws Exception {
        InputReader inputReader =
                new ResourceInputReader<>(UniversalOrbitMapPuzzle.class, "ExampleTwo.txt");

        var puzzle = new UniversalOrbitMapPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }
}
