package com.gotreaux.aoc.puzzles.year2022.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TuningTroublePuzzleTest {
    @ParameterizedTest
    @MethodSource("provideStartOfPacketMarker")
    void startOfPacketMarker(String input, int expected) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        TuningTroublePuzzle puzzle = new TuningTroublePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideStartOfMessageMarker")
    void startOfMessageMarker(String input, int expected) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        TuningTroublePuzzle puzzle = new TuningTroublePuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideStartOfPacketMarker() {
        return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 7),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 6),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11));
    }

    private static Stream<Arguments> provideStartOfMessageMarker() {
        return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26));
    }
}
