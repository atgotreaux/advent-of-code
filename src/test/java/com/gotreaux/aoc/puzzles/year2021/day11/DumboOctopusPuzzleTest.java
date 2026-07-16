package com.gotreaux.aoc.puzzles.year2021.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class DumboOctopusPuzzleTest {

    @Test
    void totalOctopusFlashes() {
        InputReader inputReader = new ResourceInputReader<>(DumboOctopusPuzzle.class);

        var puzzle = new DumboOctopusPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(1656L, output.partOne());
    }

    @Test
    void firstSynchronizedFlash() {
        InputReader inputReader = new ResourceInputReader<>(DumboOctopusPuzzle.class);

        var puzzle = new DumboOctopusPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(195, output.partTwo());
    }
}
