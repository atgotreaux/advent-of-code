package com.gotreaux.aoc.puzzles.year2015.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CorporatePolicyPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideNextPassword")
    void nextPassword(String input, String expected) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new CorporatePolicyPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    private static Stream<Arguments> provideNextPassword() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdffaa"), Arguments.of("ghijklmn", "ghjaabcc"));
    }
}
