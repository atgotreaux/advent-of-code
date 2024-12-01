package com.gotreaux.aoc.puzzles.year2024.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HistorianHysteriaPuzzleTest {

    @Test
    void sumOfDistances() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HistorianHysteriaPuzzle.class);

        HistorianHysteriaPuzzle puzzle = new HistorianHysteriaPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(11, output.partOne());
    }

    @Test
    void sumOfSimilarityScores() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HistorianHysteriaPuzzle.class);

        HistorianHysteriaPuzzle puzzle = new HistorianHysteriaPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(31, output.partTwo());
    }
}
