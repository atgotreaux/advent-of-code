package com.gotreaux.aoc.puzzles.year2016.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InternetProtocolPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideSupportsTls")
    void supportsTls(String input, int expected) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new InternetProtocolPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partOne());
    }

    @ParameterizedTest
    @MethodSource("provideSupportsSsl")
    void supportsSsl(String input, int expected) throws Exception {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new InternetProtocolPuzzle();

        var output = puzzle.solve(inputReader);

        assertEquals(expected, output.partTwo());
    }

    private static Stream<Arguments> provideSupportsTls() {
        return Stream.of(
                Arguments.of("abba[mnop]qrst", 1),
                Arguments.of("abcd[bddb]xyyx", 0),
                Arguments.of("aaaa[qwer]tyui", 0),
                Arguments.of("ioxxoj[asdfgh]zxcvbn", 1));
    }

    private static Stream<Arguments> provideSupportsSsl() {
        return Stream.of(
                Arguments.of("aba[bab]xyz", 1),
                Arguments.of("xyx[xyx]xyx", 0),
                Arguments.of("aaa[kek]eke", 1),
                Arguments.of("zazbz[bzb]cdb", 1));
    }
}
