package com.gotreaux.aoc.puzzles.year2025.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SequenceRepeatsAtLeastTwiceTest {

    @ParameterizedTest
    @MethodSource("provideTest")
    void test(Long id, boolean expectedResult) {
        var predicate = new SequenceRepeatsAtLeastTwice();

        assertEquals(expectedResult, predicate.test(id));
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(11L, true),
                Arguments.of(22L, true),
                Arguments.of(999L, true),
                Arguments.of(1010L, true),
                Arguments.of(824824821L, false),
                Arguments.of(2121212121L, true));
    }
}
