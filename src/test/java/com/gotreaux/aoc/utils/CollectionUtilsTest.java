package com.gotreaux.aoc.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CollectionUtilsTest {
    @ParameterizedTest
    @MethodSource("providePermutations")
    void permutations(List<Integer> list, int expectedSize) {
        List<List<Integer>> permutations = CollectionUtils.permutations(list);

        assertEquals(expectedSize, permutations.size());
        for (List<Integer> permutation : permutations) {
            assertEquals(list.size(), permutation.size());
        }
    }

    @ParameterizedTest
    @MethodSource("provideCircularPermutations")
    void circularPermutations(List<String> list, int expectedSize) {
        List<List<String>> permutations = CollectionUtils.circularPermutations(list);

        assertEquals(expectedSize, permutations.size());
        for (List<String> permutation : permutations) {
            assertEquals(list.size(), permutation.size());
        }
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
}
