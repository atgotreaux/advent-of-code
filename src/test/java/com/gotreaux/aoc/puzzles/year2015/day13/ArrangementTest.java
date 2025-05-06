package com.gotreaux.aoc.puzzles.year2015.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrangementTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Arrangement expected) {
        assertEquals(expected, Arrangement.of(line));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "Alice would gain 54 happiness units by sitting next to Bob.",
                        new Arrangement("Alice", "Bob", 54)),
                Arguments.of(
                        "Alice would lose 79 happiness units by sitting next to Carol.",
                        new Arrangement("Alice", "Carol", -79)));
    }
}
