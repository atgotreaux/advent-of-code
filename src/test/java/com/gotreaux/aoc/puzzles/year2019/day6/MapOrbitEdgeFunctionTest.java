package com.gotreaux.aoc.puzzles.year2019.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MapOrbitEdgeFunctionTest {

    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(String line, String expectedObject, String expectedSatellite) {
        var mapOrbitEdge = new MapOrbitEdgeFunction();

        var edge = mapOrbitEdge.apply(line);

        assertEquals(expectedObject, edge.from());
        assertEquals(expectedSatellite, edge.to());
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of("COM)B", "COM", "B"),
                Arguments.of("B)C", "B", "C"),
                Arguments.of("C)D", "C", "D"));
    }
}
