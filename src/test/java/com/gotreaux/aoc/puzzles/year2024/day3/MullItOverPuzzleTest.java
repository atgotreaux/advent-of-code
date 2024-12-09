package com.gotreaux.aoc.puzzles.year2024.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import org.junit.jupiter.api.Test;

class MullItOverPuzzleTest {

    @Test
    void sumOfMultiplications() throws Exception {
        String input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";

        InputReader inputReader = new StringInputReader(input);

        MullItOverPuzzle puzzle = new MullItOverPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(161, output.partOne());
    }

    @Test
    void sumOfEnabledMultiplications() throws Exception {
        String input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

        InputReader inputReader = new StringInputReader(input);

        MullItOverPuzzle puzzle = new MullItOverPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(48, output.partTwo());
    }
}