package com.gotreaux.aoc.puzzles.year2020.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class SeatingSystemPuzzleTest {

    @Test
    void numberOfOccupiedSeats() {
        InputReader inputReader = new ResourceInputReader<>(SeatingSystemPuzzle.class);

        var puzzle = new SeatingSystemPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(37, output.partOne());
    }
}
