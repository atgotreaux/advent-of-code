package com.gotreaux.aoc.puzzles.year2017.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SpiralMemoryPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideDistanceToAccessPort")
    void distanceToAccessPort(String input, int expectedSteps) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new SpiralMemoryPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedSteps, output.partOne());
    }

    private static Stream<Arguments> provideDistanceToAccessPort() {
        return Stream.of(
                Arguments.of("1", 0),
                Arguments.of("12", 3),
                Arguments.of("23", 2),
                Arguments.of("1024", 31));
    }
}
