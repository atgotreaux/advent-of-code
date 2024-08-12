package com.gotreaux.aoc.puzzles.year2015.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.FileInputProvider;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class HungrySciencePuzzleTest {
    @Test
    void highestScoringCookie() throws Exception {
        InputProvider inputProvider = new FileInputProvider(HungrySciencePuzzle.class);

        HungrySciencePuzzle puzzle = new HungrySciencePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(62842880, output.partOne());
    }

    @Test
    void highestScoringCalorieCookie() throws Exception {
        InputProvider inputProvider = new FileInputProvider(HungrySciencePuzzle.class);

        HungrySciencePuzzle puzzle = new HungrySciencePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(57600000, output.partTwo());
    }
}
