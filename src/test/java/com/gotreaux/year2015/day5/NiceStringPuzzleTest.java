package com.gotreaux.year2015.day5;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NiceStringPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideNiceString")
    void niceString(String input, long expectedCount) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(expectedCount, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideNiceStringBetterModel")
    void niceStringBetterModel(String input, long expectedCount) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(expectedCount, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideNiceString() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", 1L),
                Arguments.of("aaa", 1L),
                Arguments.of("jchzalrnumimnmhp", 0L),
                Arguments.of("haegwjzuvuyypxyu", 0L),
                Arguments.of("dvszwmarrgswjxmb", 0L)
        );
    }

    private static Stream<Arguments> provideNiceStringBetterModel() {
        return Stream.of(
                Arguments.of("qjhvhtzxzqqjkmpb", 1L),
                Arguments.of("xxyxx", 1L),
                Arguments.of("uurcxstgmygtbstg", 0L),
                Arguments.of("ieodomkazucvgmuy", 0L)
        );
    }
}