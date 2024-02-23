package com.gotreaux.aoc.puzzles.year2022.day5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.stream.Collectors;

abstract class CrateMover {
    protected Map<Integer, Deque<Character>> stacks;

    CrateMover(Map<Integer, Deque<Character>> stacks) {
        this.stacks =
                stacks.entrySet().stream()
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey, v -> new ArrayDeque<>(v.getValue())));
    }

    String getMessage() {
        return stacks.values().stream()
                .map(Deque::pop)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    abstract void operate(RearrangeProcedure procedure);
}
