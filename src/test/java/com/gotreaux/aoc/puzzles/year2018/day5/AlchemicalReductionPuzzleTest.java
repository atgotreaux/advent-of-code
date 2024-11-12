package com.gotreaux.aoc.puzzles.year2018.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AlchemicalReductionPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideCollapsedPolymer")
    void collapsedPolymer(String input, int expectedUnits) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        AlchemicalReductionPuzzle puzzle = new AlchemicalReductionPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expectedUnits, output.partOne());
    }

    @Test
    void shortestCollapsedPolymer() throws Exception {
        InputReader inputReader = new StringInputReader("dabAcCaCBAcCcaDA");

        AlchemicalReductionPuzzle puzzle = new AlchemicalReductionPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(4, output.partTwo());
    }

    private static Stream<Arguments> provideCollapsedPolymer() {
        return Stream.of(
                Arguments.of("aA", 0),
                Arguments.of("abBA", 0),
                Arguments.of("abAB", 4),
                Arguments.of("aabAAB", 6),
                Arguments.of("dabAcCaCBAcCcaDA", 10));
    }
}
