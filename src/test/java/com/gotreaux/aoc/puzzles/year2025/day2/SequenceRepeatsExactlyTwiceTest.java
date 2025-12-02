package com.gotreaux.aoc.puzzles.year2025.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SequenceRepeatsExactlyTwiceTest {

    @ParameterizedTest
    @MethodSource("provideTest")
    void test(Long id, boolean expectedResult) {
        var predicate = new SequenceRepeatsExactlyTwice();

        assertEquals(expectedResult, predicate.test(id));
    }

    private static Stream<Arguments> provideTest() {
        return Stream.of(
                Arguments.of(11L, true),
                Arguments.of(12L, false),
                Arguments.of(1010L, true),
                Arguments.of(1188511885L, true),
                Arguments.of(222222L, true),
                Arguments.of(446446L, true),
                Arguments.of(38593856L, false),
                Arguments.of(38593859L, true));
    }
}
