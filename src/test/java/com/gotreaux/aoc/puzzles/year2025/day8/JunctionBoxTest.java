package com.gotreaux.aoc.puzzles.year2025.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class JunctionBoxTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, JunctionBox expected) {
        assertEquals(expected, JunctionBox.of(line));
    }

    @Test
    void throwsIfInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> JunctionBox.of("162,817"));
    }

    @ParameterizedTest
    @MethodSource("provideDistanceTo")
    void distanceTo(JunctionBox junctionBox, JunctionBox other, long expected) {
        assertEquals(expected, junctionBox.distanceTo(other));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("162,817,812", new JunctionBox(162, 817, 812)),
                Arguments.of("57,618,57", new JunctionBox(57, 618, 57)),
                Arguments.of("906,360,560", new JunctionBox(906, 360, 560)));
    }

    private static Stream<Arguments> provideDistanceTo() {
        return Stream.of(
                Arguments.of(
                        new JunctionBox(162, 817, 812), new JunctionBox(425, 690, 689), 100427L),
                Arguments.of(
                        new JunctionBox(425, 690, 689), new JunctionBox(162, 817, 812), 100427L),
                Arguments.of(
                        new JunctionBox(162, 817, 812), new JunctionBox(431, 825, 988), 103401L),
                Arguments.of(new JunctionBox(162, 817, 812), new JunctionBox(162, 817, 812), 0L));
    }
}
