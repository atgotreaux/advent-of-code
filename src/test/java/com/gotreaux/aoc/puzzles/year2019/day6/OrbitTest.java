package com.gotreaux.aoc.puzzles.year2019.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OrbitTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Orbit expected) {
        assertEquals(expected, Orbit.of(line));
    }

    @Test
    void throwsIfInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> Orbit.of("COM"));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("COM)B", new Orbit("COM", "B")),
                Arguments.of("B)C", new Orbit("B", "C")),
                Arguments.of("C)D", new Orbit("C", "D")));
    }
}
