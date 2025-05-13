package com.gotreaux.aoc.puzzles.year2015.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NoRedSumNumbersFunctionTest {
    @ParameterizedTest
    @MethodSource("provideApply")
    void apply(JsonNode jsonNode, int expected) {
        var function = new NoRedSumNumbersFunction();

        assertEquals(expected, function.apply(jsonNode));
    }

    private static Stream<Arguments> provideApply() throws JsonProcessingException {
        var mapper = new ObjectMapper();

        return Stream.of(
                Arguments.of(mapper.readTree("[1,2,3]"), 6),
                Arguments.of(mapper.readTree("[1,{\"c\":\"red\",\"b\":2},3]"), 4),
                Arguments.of(mapper.readTree("{\"d\":\"red\",\"e\":[1,2,3,4],\"f\":5}"), 0),
                Arguments.of(mapper.readTree("[1,\"red\",5]"), 6));
    }
}
