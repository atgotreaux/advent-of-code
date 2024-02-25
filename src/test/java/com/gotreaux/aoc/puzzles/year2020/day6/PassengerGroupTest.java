package com.gotreaux.aoc.puzzles.year2020.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PassengerGroupTest {
    @ParameterizedTest
    @MethodSource("provideAnyoneDeclared")
    void anyoneDeclared(Collection<String> input, long expected) {
        PassengerGroup passengerGroup = new PassengerGroup(input);

        assertEquals(expected, passengerGroup.anyoneDeclared());
    }

    @ParameterizedTest
    @MethodSource("provideEveryoneDeclared")
    void everyoneDeclared(Collection<String> input, long expected) {
        PassengerGroup passengerGroup = new PassengerGroup(input);

        assertEquals(expected, passengerGroup.everyoneDeclared());
    }

    private static Stream<Arguments> provideAnyoneDeclared() {
        return Stream.of(
                Arguments.of(List.of("abc"), 3L),
                Arguments.of(List.of("a", "b", "c"), 3L),
                Arguments.of(List.of("ab", "bc"), 3L),
                Arguments.of(List.of("a", "a", "a", "a"), 1L),
                Arguments.of(List.of("b"), 1L));
    }

    private static Stream<Arguments> provideEveryoneDeclared() {
        return Stream.of(
                Arguments.of(List.of("abc"), 3L),
                Arguments.of(List.of("a", "b", "c"), 0L),
                Arguments.of(List.of("ab", "bc"), 1L),
                Arguments.of(List.of("a", "a", "a", "a"), 1L),
                Arguments.of(List.of("b"), 1L));
    }
}
