package com.gotreaux.aoc.puzzles.year2015.day12;

import static java.util.stream.StreamSupport.stream;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.function.Function;

class NoRedSumNumbersFunction implements Function<JsonNode, Integer> {
    @Override
    public Integer apply(JsonNode jsonNode) {
        return switch (jsonNode) {
            case JsonNode node when node.isNumber() -> node.asInt();
            case JsonNode node when node.isObject() -> {
                if (stream(node.spliterator(), false)
                        .anyMatch(child -> child.isTextual() && child.asText().equals("red"))) {
                    yield 0;
                }
                yield stream(node.spliterator(), false).mapToInt(this::apply).sum();
            }
            case JsonNode node when node.isArray() ->
                    stream(node.spliterator(), false).mapToInt(this::apply).sum();
            default -> 0;
        };
    }
}
