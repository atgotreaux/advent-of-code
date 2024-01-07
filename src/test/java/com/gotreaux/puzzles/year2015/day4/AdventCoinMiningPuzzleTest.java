package com.gotreaux.puzzles.year2015.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.input.StringInputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AdventCoinMiningPuzzleTest {
    @ParameterizedTest
    @MethodSource("provideFiveLeadingZeroes")
    void fiveLeadingZeroes(String input, long expectedKeyNumber) throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(input);

        AdventCoinMiningPuzzle puzzle = new AdventCoinMiningPuzzle(inputProvider);

        assertEquals(expectedKeyNumber, puzzle.getPartOne());
    }

    private static Stream<Arguments> provideFiveLeadingZeroes() {
        return Stream.of(Arguments.of("abcdef", 609043L), Arguments.of("pqrstuv", 1048970L));
    }
}
