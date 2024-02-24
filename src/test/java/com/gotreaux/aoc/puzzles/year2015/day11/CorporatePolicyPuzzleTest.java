package com.gotreaux.aoc.puzzles.year2015.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.StringInputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CorporatePolicyPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideNextPassword")
    void nextPassword(String input, String expected) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        CorporatePolicyPuzzle puzzle = new CorporatePolicyPuzzle(inputProvider);

        PuzzleOutput<String, String> output = puzzle.solve();

        assertEquals(expected, output.partOne());
    }

    private static Stream<Arguments> provideNextPassword() {
        return Stream.of(
                Arguments.of("abcdefgh", "abcdffaa"), Arguments.of("ghijklmn", "ghjaabcc"));
    }
}
