package com.gotreaux.aoc.puzzles.year2015.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WrappingPaperPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideWrappingPaperOrderTotal")
    void wrappingPaperOrderTotal(String input, int expectedOrderTotal) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new WrappingPaperPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedOrderTotal, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideRibbonOrderTotal")
    void ribbonOrderTotal(String input, int expectedOrderTotal) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new WrappingPaperPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expectedOrderTotal, output.partTwo());
    }

    private static Stream<Arguments> provideWrappingPaperOrderTotal() {
        return Stream.of(Arguments.of("2x3x4", 58), Arguments.of("1x1x10", 43));
    }

    private static Stream<Arguments> provideRibbonOrderTotal() {
        return Stream.of(Arguments.of("2x3x4", 34), Arguments.of("1x1x10", 14));
    }
}
