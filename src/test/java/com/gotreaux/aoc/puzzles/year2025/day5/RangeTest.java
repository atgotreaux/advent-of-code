package com.gotreaux.aoc.puzzles.year2025.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RangeTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, Range expectedRange) {
        assertEquals(expectedRange, Range.of(line));
    }

    @Test
    void throwsIfRangeIsNotTwoParts() {
        assertThrows(IllegalArgumentException.class, () -> Range.of("1-2-3"));
    }

    @Test
    void throwsIfStartIsGreaterThanEnd() {
        assertThrows(IllegalArgumentException.class, () -> Range.of("22-11"));
    }

    @ParameterizedTest
    @MethodSource("provideContainsId")
    void contains(Range range, long ingredientCount, boolean expectedContains) {
        assertEquals(expectedContains, range.contains(ingredientCount));
    }

    @ParameterizedTest
    @MethodSource("provideOverlaps")
    void overlaps(Range range, Range overlapped, boolean expected) {
        assertEquals(expected, range.overlaps(overlapped));
    }

    @ParameterizedTest
    @MethodSource("provideMerge")
    void merge(Range range, Range merged, Range expected) {
        assertEquals(expected, range.merge(merged));
    }

    @ParameterizedTest
    @MethodSource("provideSize")
    void size(Range range, long expectedSize) {
        assertEquals(expectedSize, range.size());
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("3-5", new Range(3L, 5L)),
                Arguments.of("10-14", new Range(10L, 14L)),
                Arguments.of("16-20", new Range(16L, 20L)),
                Arguments.of("12-18", new Range(12L, 18L)));
    }

    private static Stream<Arguments> provideContainsId() {
        return Stream.of(
                Arguments.of(new Range(3L, 5L), 1L, false),
                Arguments.of(new Range(3L, 5L), 5L, true),
                Arguments.of(new Range(16L, 20L), 8L, false),
                Arguments.of(new Range(12L, 18L), 17L, true));
    }

    private static Stream<Arguments> provideOverlaps() {
        return Stream.of(
                Arguments.of(new Range(3, 5), new Range(10, 14), false),
                Arguments.of(new Range(10, 14), new Range(12, 18), true),
                Arguments.of(new Range(16, 20), new Range(12, 18), true));
    }

    private static Stream<Arguments> provideMerge() {
        return Stream.of(
                Arguments.of(new Range(10, 14), new Range(12, 18), new Range(10, 18)),
                Arguments.of(new Range(16, 20), new Range(12, 18), new Range(12, 20)));
    }

    private static Stream<Arguments> provideSize() {
        return Stream.of(
                Arguments.of(new Range(3, 5), 3L),
                Arguments.of(new Range(10, 14), 5L),
                Arguments.of(new Range(16, 20), 5L),
                Arguments.of(new Range(12, 18), 7L));
    }
}
