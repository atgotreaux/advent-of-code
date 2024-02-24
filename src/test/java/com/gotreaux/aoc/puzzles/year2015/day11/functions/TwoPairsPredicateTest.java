package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TwoPairsPredicateTest {
    @ParameterizedTest
    @MethodSource("provideTest")
    void test(String input, boolean expected) {
        TwoPairsPredicate predicate = new TwoPairsPredicate();

        assertEquals(expected, predicate.test(input));
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("hijklmmn", false),
                Arguments.of("abbceffg", true),
                Arguments.of("abbcegjk", false),
                Arguments.of("abcdefgh", false),
                Arguments.of("abcdffaa", true),
                Arguments.of("ghijklmn", false),
                Arguments.of("ghjaabcc", true));
    }
}
