package com.gotreaux.aoc.puzzles.year2019.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SecureContainerPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideValidPasswords")
    void validPasswords(String input, int expected) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new SecureContainerPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideValidPasswordsNoLargerGroups")
    void validPasswordsNoLargerGroups(String input, int expected) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new SecureContainerPuzzle();

        var output = puzzle.solve(inputReader);

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
