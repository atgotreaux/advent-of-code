package com.gotreaux.aoc.puzzles.year2015.day16;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiPredicate;

record Aunt(int id, Map<Attribute, Integer> attributes) {

    static Aunt of(String line) {
        var parts = line.replace(":", "").replace(",", "").split(" ");
        var length = parts.length;

        var id = Integer.parseInt(parts[1]);
        Map<Attribute, Integer> attributes = new EnumMap<>(Attribute.class);
        for (var i = 2; i < length; i += 2) {
            var attribute = Attribute.valueOf(parts[i].toUpperCase(Locale.getDefault()));
            attributes.put(attribute, Integer.parseInt(parts[i + 1]));
        }

        return new Aunt(id, attributes);
    }

    boolean matches(Attribute attribute, int expected, BiPredicate<Integer, Integer> matcher) {
        return !attributes.containsKey(attribute)
                || matcher.test(attributes.get(attribute), expected);
    }
}
