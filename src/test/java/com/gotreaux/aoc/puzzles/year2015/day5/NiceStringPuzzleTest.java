package com.gotreaux.aoc.puzzles.year2015.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NiceStringPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideNiceString")
    void niceString(String input, int expectedCount) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(expectedCount, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideNiceStringBetterModel")
    void niceStringBetterModel(String input, int expectedCount) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        PuzzleOutput<Long, Long> output = puzzle.solve();

        assertEquals(expectedCount, output.partTwo());
    }

    private static Stream<Arguments> provideNiceString() {
        return Stream.of(
                Arguments.of("ugknbfddgicrmopn", 1),
                Arguments.of("aaa", 1),
                Arguments.of("jchzalrnumimnmhp", 0),
                Arguments.of("haegwjzuvuyypxyu", 0),
                Arguments.of("dvszwmarrgswjxmb", 0));
    }

    private static Stream<Arguments> provideNiceStringBetterModel() {
        return Stream.of(
                Arguments.of("qjhvhtzxzqqjkmpb", 1),
                Arguments.of("xxyxx", 1),
                Arguments.of("uurcxstgmygtbstg", 0),
                Arguments.of("ieodomkazucvgmuy", 0));
    }
}
