package com.gotreaux.aoc.puzzles.year2024.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class HistorianHysteriaPuzzleTest {

    @Test
    void sumOfDistances() {
        InputReader inputReader = new ResourceInputReader<>(HistorianHysteriaPuzzle.class);

        var puzzle = new HistorianHysteriaPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(11, output.partOne());
    }

    @Test
    void sumOfSimilarityScores() {
        InputReader inputReader = new ResourceInputReader<>(HistorianHysteriaPuzzle.class);

        var puzzle = new HistorianHysteriaPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(31, output.partTwo());
    }
}
