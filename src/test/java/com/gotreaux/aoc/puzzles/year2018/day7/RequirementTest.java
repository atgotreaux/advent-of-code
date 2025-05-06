package com.gotreaux.aoc.puzzles.year2018.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RequirementTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Requirement expected) {
        assertEquals(expected, Requirement.of(line));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "Step C must be finished before step A can begin.",
                        new Requirement("C", "A")),
                Arguments.of(
                        "Step C must be finished before step F can begin.",
                        new Requirement("C", "F")),
                Arguments.of(
                        "Step A must be finished before step B can begin.",
                        new Requirement("A", "B")));
    }
}
