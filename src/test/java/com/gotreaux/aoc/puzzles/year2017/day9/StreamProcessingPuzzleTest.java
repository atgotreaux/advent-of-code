package com.gotreaux.aoc.puzzles.year2017.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StreamProcessingPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideTotalScore")
    void totalScore(String input, int expectedScore) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        StreamProcessingPuzzle puzzle = new StreamProcessingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(expectedScore, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideGarbageCount")
    void garbageCount(String input, int expectedCount) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        StreamProcessingPuzzle puzzle = new StreamProcessingPuzzle();

        PuzzleOutput<Integer, Integer> output = puzzle.solve(inputProvider);

        assertEquals(expectedCount, output.partTwo());
    }

    private static Stream<Arguments> provideTotalScore() {
        return Stream.of(
                Arguments.of("{}", 1),
                Arguments.of("{{{}}}", 6),
                Arguments.of("{{},{}}", 5),
                Arguments.of("{{{},{},{{}}}}", 16),
                Arguments.of("{<a>,<a>,<a>,<a>}", 1),
                Arguments.of("{{<ab>},{<ab>},{<ab>},{<ab>}}", 9),
                Arguments.of("{{<!!>},{<!!>},{<!!>},{<!!>}}", 9),
                Arguments.of("{{<a!>},{<a!>},{<a!>},{<ab>}}", 3));
    }

    private static Stream<Arguments> provideGarbageCount() {
        return Stream.of(
                Arguments.of("<>", 0),
                Arguments.of("<random characters>", 17),
                Arguments.of("<<<<", 3),
                Arguments.of("<{!>}>", 2),
                Arguments.of("<!!>", 0),
                Arguments.of("<!!!>>", 0),
                Arguments.of("<{o\"i!a,<{i<a>", 10));
    }
}
