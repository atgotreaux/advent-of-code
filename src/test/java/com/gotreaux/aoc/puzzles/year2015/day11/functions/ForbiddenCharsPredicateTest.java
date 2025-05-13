package com.gotreaux.aoc.puzzles.year2015.day11.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ForbiddenCharsPredicateTest {
    @ParameterizedTest
    @MethodSource("provideTest")
    void test(String input, boolean expected) {
        var predicate = new ForbiddenCharsPredicate();

        assertEquals(expected, predicate.test(input));
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of("hijklmmn", false),
                Arguments.of("abbceffg", true),
                Arguments.of("abbcegjk", true),
                Arguments.of("abcdefgh", true),
                Arguments.of("abcdffaa", true),
                Arguments.of("ghijklmn", false),
                Arguments.of("ghjaabcc", true));
    }
}
