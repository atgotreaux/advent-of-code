package com.gotreaux.aoc.puzzles.year2022.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CathodeRayTubePuzzleTest {
    @Test
    void sumOfSignalStrengths() {
        InputReader inputReader = new ResourceInputReader<>(CathodeRayTubePuzzle.class);

        var puzzle = new CathodeRayTubePuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(13140, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideSignalStrength")
    void signalStrength(int cycles, int expected) {
        InputReader inputReader = new ResourceInputReader<>(CathodeRayTubePuzzle.class);

        var input = inputReader.getInputList();

        assertEquals(expected, CathodeRayTubePuzzle.getSignalStrength(input, cycles));
    }

    private static Stream<Arguments> provideSignalStrength() {
        return Stream.of(
                Arguments.of(20, 420),
                Arguments.of(60, 1140),
                Arguments.of(100, 1800),
                Arguments.of(140, 2940),
                Arguments.of(180, 2880),
                Arguments.of(220, 3960));
    }
}
