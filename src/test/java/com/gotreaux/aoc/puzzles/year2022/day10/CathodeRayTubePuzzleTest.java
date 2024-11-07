package com.gotreaux.aoc.puzzles.year2022.day10;

import static org.junit.jupiter.api.Assertions.*;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.ResourceInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CathodeRayTubePuzzleTest {
    @Test
    void sumOfSignalStrengths() throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CathodeRayTubePuzzle.class);

        CathodeRayTubePuzzle puzzle = new CathodeRayTubePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(13140, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideSignalStrength")
    void signalStrength(int cycles, int expected) throws Exception {
        InputProvider inputProvider = new ResourceInputProvider<>(CathodeRayTubePuzzle.class);

        List<String> input = inputProvider.getInputList();

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
