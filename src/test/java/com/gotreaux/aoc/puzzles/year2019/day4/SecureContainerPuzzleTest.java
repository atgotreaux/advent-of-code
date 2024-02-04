package com.gotreaux.aoc.puzzles.year2019.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SecureContainerPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideValidPasswords")
    void validPasswords(String input, int expected) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        SecureContainerPuzzle puzzle = new SecureContainerPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideValidPasswordsNoLargerGroups")
    void validPasswordsNoLargerGroups(String input, int expected) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        SecureContainerPuzzle puzzle = new SecureContainerPuzzle(inputProvider);

        PuzzleOutput<Integer, Integer> output = puzzle.solve();

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideValidPasswords() {
        return Stream.of(
                Arguments.of("111111-111111", 1),
                Arguments.of("223450-223450", 0),
                Arguments.of("123789-123789", 0));
    }

    private static Stream<Arguments> provideValidPasswordsNoLargerGroups() {
        return Stream.of(
                Arguments.of("112233-112233", 1),
                Arguments.of("123444-123444", 0),
                Arguments.of("111122-111122", 1));
    }
}
