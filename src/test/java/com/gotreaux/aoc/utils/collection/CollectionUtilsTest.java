package com.gotreaux.aoc.utils.collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.utils.cartesian.CardinalDirection;
import com.gotreaux.aoc.utils.cartesian.RelativeDirection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CollectionUtilsTest {
    @ParameterizedTest
    @MethodSource("providePermutations")
    void permutations(List<Integer> list, int expectedSize) {
        var permutations = CollectionUtils.permutations(list);

        assertEquals(expectedSize, permutations.size());
        for (var permutation : permutations) {
            assertEquals(list.size(), permutation.size());
        }
    }

    @ParameterizedTest
    @MethodSource("provideCircularPermutations")
    void circularPermutations(List<String> list, int expectedSize) {
        var permutations = CollectionUtils.circularPermutations(list);

        assertEquals(expectedSize, permutations.size());
        for (var permutation : permutations) {
            assertEquals(list.size(), permutation.size());
        }
    }

    @ParameterizedTest
    @MethodSource("provideCombinations")
    void combinations(List<String> elements, int length, int expectedSize) {
        var combinations = CollectionUtils.combinations(elements, length);

        assertEquals(expectedSize, combinations.size());
        assertEquals(
                Integer.toUnsignedLong(expectedSize), combinations.stream().distinct().count());
    }

    @ParameterizedTest
    @MethodSource("provideOptionalValues")
    <T> void optionalValues(T[] elements) {
        var optionalValues = CollectionUtils.optionalValues(elements);

        assertEquals(elements.length + 1, optionalValues.size());
        assertEquals(1L, optionalValues.stream().filter(Optional::isEmpty).count());
        assertEquals(
                elements.length,
                optionalValues.stream().filter(Optional::isPresent).distinct().count());
    }

    @ParameterizedTest
    @MethodSource("providePairs")
    void pairs(List<String> elements, List<Pair<String, String>> expectedPairs) {
        var pairs = CollectionUtils.pairs(elements);

        assertEquals(expectedPairs, pairs.stream().toList());
    }

    private static Stream<Arguments> providePermutations() {
        return Stream.of(
                Arguments.of(List.of(1), 1),
                Arguments.of(List.of(1, 2), 2),
                Arguments.of(List.of(1, 2, 3), 6),
                Arguments.of(List.of(1, 2, 3, 4), 24));
    }

    private static Stream<Arguments> provideCircularPermutations() {
        return Stream.of(
                Arguments.of(List.of("Alice", "Bob", "Carol"), 2),
                Arguments.of(List.of("Alice", "Bob", "Carol", "David"), 6));
    }

    private static Stream<Arguments> provideCombinations() {
        return Stream.of(
                Arguments.of(List.of("+", "*"), 1, 2),
                Arguments.of(List.of("+", "*"), 2, 4),
                Arguments.of(List.of("+", "*"), 3, 8),
                Arguments.of(List.of("+", "*"), 5, 32));
    }

    private static Stream<Arguments> provideOptionalValues() {
        return Stream.of(
                Arguments.of((Object) CardinalDirection.values()),
                Arguments.of((Object) RelativeDirection.values()));
    }

    private static Stream<Arguments> providePairs() {
        return Stream.of(
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of("a"), List.of()),
                Arguments.of(List.of("a", "b"), List.of(new Pair<>("a", "b"))),
                Arguments.of(
                        List.of("a", "b", "c"),
                        List.of(new Pair<>("a", "b"), new Pair<>("a", "c"), new Pair<>("b", "c"))),
                Arguments.of(
                        List.of("a", "b", "c", "d"),
                        List.of(
                                new Pair<>("a", "b"),
                                new Pair<>("a", "c"),
                                new Pair<>("a", "d"),
                                new Pair<>("b", "c"),
                                new Pair<>("b", "d"),
                                new Pair<>("c", "d"))),
                Arguments.of(List.of("a", "a"), List.of(new Pair<>("a", "a"))));
    }
}
