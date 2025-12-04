package com.gotreaux.aoc.puzzles.year2015.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.StringInputReader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AdventCoinMiningPuzzleTest {

    @ParameterizedTest
    @MethodSource("provideFiveLeadingZeroes")
    void fiveLeadingZeroes(String input, int expectedKeyNumber) {
        InputReader inputReader = new StringInputReader(input);

        var puzzle = new AdventCoinMiningPuzzle();

        assertEquals(expectedKeyNumber, puzzle.solvePartOne(inputReader));
    }

    private static Stream<Arguments> provideFiveLeadingZeroes() {
        return Stream.of(Arguments.of("abcdef", 609043), Arguments.of("pqrstuv", 1048970));
    }
}
