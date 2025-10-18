package com.gotreaux.aoc.puzzles.year2023.day9;

import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record History(List<Integer> values) {

    static History of(String line) {
        var parts = PatternUtils.ANY_WHITESPACE.split(line.trim());

        if (parts.length < 2) {
            throw new IllegalArgumentException("History must have at least two values");
        }

        var values = Arrays.stream(parts).map(Integer::parseInt).toList();

        return new History(values);
    }

    int extrapolate(Direction direction) {
        List<List<Integer>> sequences = new ArrayList<>();
        sequences.add(new ArrayList<>(values));

        while (!sequences.getLast().stream().allMatch(i -> i == 0)) {
            var previousSequence = sequences.getLast();
            List<Integer> differences = new ArrayList<>(previousSequence.size() - 1);
            for (var i = 1; i < previousSequence.size(); i++) {
                differences.add(previousSequence.get(i) - previousSequence.get(i - 1));
            }
            sequences.add(differences);
        }

        var result = 0;
        for (var i = sequences.size() - 1; i >= 0; i--) {
            var sequence = sequences.get(i);
            result =
                    switch (direction) {
                        case FORWARD -> sequence.getLast() + result;
                        case BACKWARD -> sequence.getFirst() - result;
                    };
        }
        return result;
    }
}
