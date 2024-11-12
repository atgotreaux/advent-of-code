package com.gotreaux.aoc.puzzles.year2015.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HungrySciencePuzzleTest {
    @Test
    void highestScoringCookie() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HungrySciencePuzzle.class);

        HungrySciencePuzzle puzzle = new HungrySciencePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(62842880, output.partOne());
    }

    @Test
    void highestScoringCalorieCookie() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(HungrySciencePuzzle.class);

        HungrySciencePuzzle puzzle = new HungrySciencePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(57600000, output.partTwo());
    }
}
