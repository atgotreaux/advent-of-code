package com.gotreaux.aoc.puzzles.year2015.day19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.utils.graph.Edge;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MapReplacementEdgeFunctionTest {

    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(String line, String expectedFrom, String expectedTo) {
        MapReplacementEdgeFunction mapReplacementEdge = new MapReplacementEdgeFunction();
        Edge replacement = mapReplacementEdge.apply(line);

        assertEquals(expectedFrom, replacement.from());
        assertEquals(expectedTo, replacement.to());
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of("H => HO", "H", "HO"),
                Arguments.of("H => OH", "H", "OH"),
                Arguments.of("O => HH", "O", "HH"));
    }
}
