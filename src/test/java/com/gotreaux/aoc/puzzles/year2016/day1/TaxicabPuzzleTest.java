package com.gotreaux.aoc.puzzles.year2016.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TaxicabPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideShortestPath")
    void shortestPath(String input, int expectedDistance) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        TaxicabPuzzle puzzle = new TaxicabPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expectedDistance, output.partOne());
    }

    @Test
    void firstDupPath() throws Exception {
        InputReader inputReader = new StringInputReader("R8, R4, R4, R8");

        TaxicabPuzzle puzzle = new TaxicabPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }

    private static Stream<Arguments> provideShortestPath() {
        return Stream.of(
                Arguments.of("R2, L3", 5),
                Arguments.of("R2, R2, R2", 2),
                Arguments.of("R5, L5, R5, R3", 12));
    }
}
