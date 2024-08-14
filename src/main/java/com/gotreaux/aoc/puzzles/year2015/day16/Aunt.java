package com.gotreaux.aoc.puzzles.year2015.day16;

import java.util.Map;
import java.util.function.BiPredicate;

record Aunt(int id, Map<Attribute, Integer> attributes) {
    boolean matches(Attribute attribute, int expected, BiPredicate<Integer, Integer> matcher) {
        return !attributes.containsKey(attribute)
                || matcher.test(attributes.get(attribute), expected);
    }
}
