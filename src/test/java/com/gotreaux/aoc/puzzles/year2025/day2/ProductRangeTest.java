package com.gotreaux.aoc.puzzles.year2025.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.List;
import java.util.function.LongPredicate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProductRangeTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, ProductRange expectedProductRange) {
        assertEquals(expectedProductRange, ProductRange.of(line));
    }

    @Test
    void throwsIfRangeIsNotTwoParts() {
        assertThrows(IllegalArgumentException.class, () -> ProductRange.of("1-2-3"));
    }

    @Test
    void throwsIfStartIsGreaterThanEnd() {
        assertThrows(IllegalArgumentException.class, () -> ProductRange.of("22-11"));
    }

    @ParameterizedTest
    @MethodSource("provideFindInvalidIds")
    void findInvalidIds(
            ProductRange productRange,
            LongPredicate longPredicate,
            Collection<Long> expectedInvalidIds) {
        assertEquals(expectedInvalidIds, productRange.findInvalidIds(longPredicate));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("11-22", new ProductRange(11L, 22L)),
                Arguments.of("95-115", new ProductRange(95L, 115L)),
                Arguments.of("998-1012", new ProductRange(998L, 1012L)),
                Arguments.of("1188511880-1188511890", new ProductRange(1188511880L, 1188511890L)),
                Arguments.of("2121212118-2121212124", new ProductRange(2121212118L, 2121212124L)));
    }

    private static Stream<Arguments> provideFindInvalidIds() {
        return Stream.of(
                Arguments.of(
                        new ProductRange(11L, 22L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(11L, 22L)),
                Arguments.of(
                        new ProductRange(95L, 115L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(99L)),
                Arguments.of(
                        new ProductRange(1188511880L, 1188511890L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(1188511885L)),
                Arguments.of(
                        new ProductRange(222220L, 222224L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(222222L)),
                Arguments.of(
                        new ProductRange(1698522L, 1698528L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of()),
                Arguments.of(
                        new ProductRange(446443L, 446449L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(446446L)),
                Arguments.of(
                        new ProductRange(38593856L, 38593862L),
                        new SequenceRepeatsExactlyTwice(),
                        List.of(38593859L)),
                Arguments.of(
                        new ProductRange(11L, 22L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(11L, 22L)),
                Arguments.of(
                        new ProductRange(95L, 115L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(99L, 111L)),
                Arguments.of(
                        new ProductRange(998L, 1012L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(999L, 1010L)),
                Arguments.of(
                        new ProductRange(1188511880L, 1188511890L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(1188511885L)),
                Arguments.of(
                        new ProductRange(222220L, 222224L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(222222L)),
                Arguments.of(
                        new ProductRange(1698522L, 1698528L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of()),
                Arguments.of(
                        new ProductRange(446443L, 446449L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(446446L)),
                Arguments.of(
                        new ProductRange(38593856L, 38593862L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(38593859L)),
                Arguments.of(
                        new ProductRange(565653L, 565659L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(565656L)),
                Arguments.of(
                        new ProductRange(824824821L, 824824827L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(824824824L)),
                Arguments.of(
                        new ProductRange(2121212118L, 2121212124L),
                        new SequenceRepeatsAtLeastTwice(),
                        List.of(2121212121L)));
    }
}
