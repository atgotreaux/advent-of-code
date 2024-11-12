package com.gotreaux.aoc.puzzles.year2017.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HighEntropyPassphrasePuzzleTest {
    @ParameterizedTest
    @MethodSource("provideUniquePassphraseWords")
    void uniquePassphraseWords(String input, int expectedCount) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        HighEntropyPassphrasePuzzle puzzle = new HighEntropyPassphrasePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expectedCount, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideNoPassphraseWordAnagrams")
    void noPassphraseWordAnagrams(String input, int expectedCount) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        HighEntropyPassphrasePuzzle puzzle = new HighEntropyPassphrasePuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputReader);

        assertEquals(expectedCount, output.partTwo());
    }

    private static Stream<Arguments> provideUniquePassphraseWords() {
        return Stream.of(
                Arguments.of("aa bb cc dd ee", 1),
                Arguments.of("aa bb cc dd aa", 0),
                Arguments.of("aa bb cc dd aaa", 1));
    }

    private static Stream<Arguments> provideNoPassphraseWordAnagrams() {
        return Stream.of(
                Arguments.of("abcde fghij", 1),
                Arguments.of("abcde xyz ecdab", 0),
                Arguments.of("a ab abc abd abf abj", 1),
                Arguments.of("iiii oiii ooii oooi oooo", 1),
                Arguments.of("oiii ioii iioi iiio", 0));
    }
}
