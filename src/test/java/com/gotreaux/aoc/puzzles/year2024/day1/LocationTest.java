package com.gotreaux.aoc.puzzles.year2024.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LocationTest {

    @ParameterizedTest
    @MethodSource("provideSimilarityScore")
    void similarityScore(Location location, Collection<Integer> ids, int expectedSimilarityScore) {
        Collection<Location> locations = ids.stream().map(Location::new).toList();

        assertEquals(expectedSimilarityScore, location.getSimilarityScore(locations));
    }

    private static Stream<Arguments> provideSimilarityScore() {
        return Stream.of(
                Arguments.of(new Location(3), List.of(4, 3, 5, 3, 9, 3), 9),
                Arguments.of(new Location(4), List.of(4, 3, 5, 3, 9, 3), 4),
                Arguments.of(new Location(2), List.of(4, 3, 5, 3, 9, 3), 0),
                Arguments.of(new Location(1), List.of(4, 3, 5, 3, 9, 3), 0),
                Arguments.of(new Location(3), List.of(4, 3, 5, 3, 9, 3), 9),
                Arguments.of(new Location(3), List.of(4, 3, 5, 3, 9, 3), 9));
    }
}
