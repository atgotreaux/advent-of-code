package com.gotreaux.aoc.puzzles.year2023.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HistoryTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, History expectedHistory) {
        assertEquals(expectedHistory, History.of(line));
    }

    @Test
    void throwsIfIncorrectHistoryLength() {
        assertThrows(IllegalArgumentException.class, () -> History.of("1"));
    }

    @ParameterizedTest
    @MethodSource("provideExtrapolate")
    void extrapolate(History history, Direction direction, int expectedExtrapolation) {
        assertEquals(expectedExtrapolation, history.extrapolate(direction));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("0 3 6 9 12 15", new History(List.of(0, 3, 6, 9, 12, 15))),
                Arguments.of("1 3 6 10 15 21", new History(List.of(1, 3, 6, 10, 15, 21))),
                Arguments.of("10 13 16 21 30 45", new History(List.of(10, 13, 16, 21, 30, 45))));
    }

    private static Stream<Arguments> provideExtrapolate() {
        return Stream.of(
                Arguments.of(new History(List.of(0, 3, 6, 9, 12, 15)), Direction.FORWARD, 18),
                Arguments.of(new History(List.of(1, 3, 6, 10, 15, 21)), Direction.FORWARD, 28),
                Arguments.of(new History(List.of(10, 13, 16, 21, 30, 45)), Direction.FORWARD, 68),
                Arguments.of(new History(List.of(10, 13, 16, 21, 30, 45)), Direction.BACKWARD, 5));
    }
}
