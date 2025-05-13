package com.gotreaux.aoc.puzzles.year2015.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AbacusFrameworkPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideSumOfNumbers")
    void sumOfNumbers(String input, int expected) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new AbacusFrameworkPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideNoRedSumNumbers")
    void noRedSumNumbers(String input, int expected) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new AbacusFrameworkPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideSumOfNumbers() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("{\"a\":2,\"b\":4}", 6),
                Arguments.of("[[[3]]]", 3));
    }

    private static Stream<Arguments> provideNoRedSumNumbers() {
        return Stream.of(
                Arguments.of("[1,2,3]", 6),
                Arguments.of("[1,{\"c\":\"red\",\"b\":2},3]", 4),
                Arguments.of("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}", 0),
                Arguments.of("[1,\"red\",5]", 6));
    }
}
