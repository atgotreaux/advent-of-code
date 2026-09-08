package com.gotreaux.aoc.utils.graph.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.ToLongBiFunction;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WeightedEdgeTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(ToLongBiFunction<Long, Long> weigher, long expectedWeight) {
        var edge = WeightedEdge.of(8L, 3L, weigher);

        assertEquals(expectedWeight, edge.weight());
    }

    @ParameterizedTest
    @MethodSource("provideWeights")
    void compareTo(long weight, long otherWeight, int expectedSignum) {
        Comparable<WeightedEdge<String>> edge = new WeightedEdge<>("A", "B", weight);
        var other = new WeightedEdge<>("C", "D", otherWeight);

        assertEquals(expectedSignum, edge.compareTo(other));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                weigher(Long::sum, 11L), weigher(Long::max, 8L), weigher(Math::multiplyExact, 24L));
    }

    private static Arguments weigher(ToLongBiFunction<Long, Long> weigher, long expectedWeight) {
        return Arguments.of(weigher, expectedWeight);
    }

    private static Stream<Arguments> provideWeights() {
        return Stream.of(
                Arguments.of(1L, 2L, -1),
                Arguments.of(2L, 1L, 1),
                Arguments.of(2L, 2L, 0),
                Arguments.of(0L, 0L, 0),
                Arguments.of(Long.MIN_VALUE, Long.MAX_VALUE, -1),
                Arguments.of(Long.MAX_VALUE, Long.MIN_VALUE, 1),
                Arguments.of(Long.MAX_VALUE, Long.MAX_VALUE, 0));
    }
}
