package com.gotreaux.aoc.puzzles.year2020.day11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SeatTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(char label, Seat expectedSeat) {
        assertEquals(expectedSeat, Seat.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Seat.of('X'));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of('L', Seat.EMPTY),
                Arguments.of('#', Seat.OCCUPIED),
                Arguments.of('.', Seat.FLOOR));
    }
}
