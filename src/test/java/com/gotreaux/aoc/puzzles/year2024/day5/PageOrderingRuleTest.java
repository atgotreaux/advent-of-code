package com.gotreaux.aoc.puzzles.year2024.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PageOrderingRuleTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, int expectedBefore, int expectedAfter) {
        PageOrderingRule rule = PageOrderingRule.of(line);

        assertEquals(expectedBefore, rule.before());
        assertEquals(expectedAfter, rule.after());
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("47|53", 47, 53),
                Arguments.of("97|13", 97, 13),
                Arguments.of("97|61", 97, 61));
    }
}
