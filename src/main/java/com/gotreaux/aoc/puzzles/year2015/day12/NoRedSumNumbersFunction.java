package com.gotreaux.aoc.puzzles.year2015.day12;

import java.util.function.Function;
import java.util.stream.IntStream;
import org.json.JSONArray;
import org.json.JSONObject;

class NoRedSumNumbersFunction implements Function<Object, Integer> {
    @Override
    public Integer apply(Object o) {
        return switch (o) {
            case Integer i -> i;
            case JSONArray array ->
                    IntStream.range(0, array.length()).map(i -> apply(array.get(i))).sum();
            case JSONObject obj -> {
                if (obj.keySet().stream().anyMatch(key -> obj.get(key).equals("red"))) {
                    yield 0;
                }
                yield obj.keySet().stream().mapToInt(key -> apply(obj.get(key))).sum();
            }
            default -> 0;
        };
    }
}
