package com.gotreaux.aoc.puzzles.year2015.day12;

import java.util.function.Function;
import java.util.stream.StreamSupport;
import tools.jackson.databind.JsonNode;

class SumOfNumbersFunction implements Function<JsonNode, Integer> {
    @Override
    public Integer apply(JsonNode jsonNode) {
        if (jsonNode.isNumber()) {
            return jsonNode.asInt();
        }

        return StreamSupport.stream(jsonNode.spliterator(), false).mapToInt(this::apply).sum();
    }
}
