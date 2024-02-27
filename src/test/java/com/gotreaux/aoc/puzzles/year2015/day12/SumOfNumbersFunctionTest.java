package com.gotreaux.aoc.puzzles.year2015.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumOfNumbersFunctionTest {
    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(Object o, int expected) {
        NoRedSumNumbersFunction function = new NoRedSumNumbersFunction();

        assertEquals(expected, function.apply(o));
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of(new JSONArray("[1,2,3]"), 6),
                Arguments.of(new JSONObject("{\"a\":2,\"b\":4}"), 6),
                Arguments.of(new JSONArray("[[[3]]]"), 3));
    }
}
