package com.gotreaux.aoc.puzzles.year2018.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class ReposeRecordPuzzleTest {

    @Test
    void guardMostMinutesAsleep() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReposeRecordPuzzle.class);

        var puzzle = new ReposeRecordPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(240, output.partOne());
    }

    @Test
    void guardMinuteMostFrequentlyAsleep() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(ReposeRecordPuzzle.class);

        var puzzle = new ReposeRecordPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(4455, output.partTwo());
    }
}
