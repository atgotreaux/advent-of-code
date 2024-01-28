package com.gotreaux.aoc.puzzles.year2017.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InverseCaptchaPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideSumOfNextDigitsMatching")
    void sumOfNextDigitsMatching(String input, int expectedSum) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        InverseCaptchaPuzzle puzzle = new InverseCaptchaPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expectedSum, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideSumOfHalfwayDigitsMatching")
    void sumOfHalfwayDigitsMatching(String input, int expectedSum) throws Exception {
        InputProvider inputProvider = new StringInputProvider(input);

        InverseCaptchaPuzzle puzzle = new InverseCaptchaPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expectedSum, output.partTwo());
    }

    private static Stream<Arguments> provideSumOfNextDigitsMatching() {
        return Stream.of(
                Arguments.of("1122", 3),
                Arguments.of("1111", 4),
                Arguments.of("1234", 0),
                Arguments.of("91212129", 9));
    }

    private static Stream<Arguments> provideSumOfHalfwayDigitsMatching() {
        return Stream.of(
                Arguments.of("1212", 6),
                Arguments.of("1221", 0),
                Arguments.of("123425", 4),
                Arguments.of("123123", 12),
                Arguments.of("12131415", 4));
    }
}
