package com.gotreaux.aoc.puzzles.year2015.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NoRedSumNumbersFunctionTest {
    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(Object o, int expected) {
        NoRedSumNumbersFunction function = new NoRedSumNumbersFunction();

        assertEquals(expected, function.apply(o));
    }

    private static Stream<Arguments> provideApply() {
        return Stream.of(
                Arguments.of(new JSONArray("[1,2,3]"), 6),
                Arguments.of(new JSONArray("[1,{\"c\":\"red\",\"b\":2},3]"), 4),
                Arguments.of(new JSONObject("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"), 0),
                Arguments.of(new JSONArray("[1,\"red\",5]"), 6));
    }
}
