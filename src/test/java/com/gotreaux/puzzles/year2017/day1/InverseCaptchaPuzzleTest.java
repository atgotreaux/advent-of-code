package com.gotreaux.puzzles.year2017.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.StringInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InverseCaptchaPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideSumOfNextDigitsMatching")
    void sumOfNextDigitsMatching(String input, long expectedSum) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        InverseCaptchaPuzzle puzzle = new InverseCaptchaPuzzle(inputProvider);

        assertEquals(expectedSum, puzzle.getPartOne());
    }

    @ParameterizedTest
    @MethodSource("provideSumOfHalfwayDigitsMatching")
    void sumOfHalfwayDigitsMatching(String input, long expectedSum) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        InverseCaptchaPuzzle puzzle = new InverseCaptchaPuzzle(inputProvider);

        assertEquals(expectedSum, puzzle.getPartTwo());
    }

    private static Stream<Arguments> provideSumOfNextDigitsMatching() {
        return Stream.of(
                Arguments.of("1122", 3L),
                Arguments.of("1111", 4L),
                Arguments.of("1234", 0L),
                Arguments.of("91212129", 9L));
    }

    private static Stream<Arguments> provideSumOfHalfwayDigitsMatching() {
        return Stream.of(
                Arguments.of("1212", 6L),
                Arguments.of("1221", 0L),
                Arguments.of("123425", 4L),
                Arguments.of("123123", 12L),
                Arguments.of("12131415", 4L));
    }
}
