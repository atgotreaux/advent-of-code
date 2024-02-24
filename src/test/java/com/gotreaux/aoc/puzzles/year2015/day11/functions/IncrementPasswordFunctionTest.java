package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IncrementPasswordFunctionTest {
    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(String input, String expected) {
        Function<String, String> function = new IncrementPasswordFunction();

        assertEquals(expected, function.apply(input));
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdefgi"),
                Arguments.of("abcdefgz", "abcdefha"),
                Arguments.of("abcdefzz", "abcdegaa"),
                Arguments.of("zzzzzzzz", "aaaaaaaaa"));
    }
}
