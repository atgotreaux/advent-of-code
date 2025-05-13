package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IncreasingCharsPredicateTest {
    @ParameterizedTest
    @MethodSource("provideTest")
    void test(String input, boolean expected) {
        var predicate = new IncreasingCharsPredicate();

        assertEquals(expected, predicate.test(input));
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("hijklmmn", true),
                Arguments.of("abbceffg", false),
                Arguments.of("abbcegjk", false),
                Arguments.of("abcdefgh", true),
                Arguments.of("abcdffaa", true),
                Arguments.of("ghijklmn", true),
                Arguments.of("ghjaabcc", true));
    }
}
