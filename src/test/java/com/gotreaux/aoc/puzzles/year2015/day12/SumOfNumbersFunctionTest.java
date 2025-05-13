package com.gotreaux.aoc.puzzles.year2015.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumOfNumbersFunctionTest {
    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(JsonNode jsonNode, int expected) {
        var function = new SumOfNumbersFunction();

        assertEquals(expected, function.apply(jsonNode));
    }

    private static Stream<Arguments> provideApply() throws JsonProcessingException {
        var mapper = new ObjectMapper();

        return Stream.of(
                Arguments.of(mapper.readTree("[1,2,3]"), 6),
                Arguments.of(mapper.readTree("{\"a\":2,\"b\":4}"), 6),
                Arguments.of(mapper.readTree("[[[3]]]"), 3));
    }
}
