package com.gotreaux.year2015.day2;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WrappingPaperPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideWrappingPaperOrderTotal")
    void wrappingPaperOrderTotal(String input, long expectedOrderTotal) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        assertEquals(expectedOrderTotal, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideRibbonOrderTotal")
    void ribbonOrderTotal(String input, long expectedOrderTotal) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        assertEquals(expectedOrderTotal, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideWrappingPaperOrderTotal() {
        return Stream.of(
                Arguments.of("2x3x4", 58L),
                Arguments.of("1x1x10", 43L)
        );
    }

    private static Stream<Arguments> provideRibbonOrderTotal() {
        return Stream.of(
                Arguments.of("2x3x4", 34L),
                Arguments.of("1x1x10", 14L)
        );
    }
}