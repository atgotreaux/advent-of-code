package com.gotreaux.aoc.puzzles.year2020.day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Luggage {

    private static final Pattern BAGS_CONTAIN_PATTERN = Pattern.compile(" bags contain ");
    private static final Pattern BAGS_CONTAIN_LIST_PATTERN = Pattern.compile(", ");

    private final Map<String, Bag> bags;

    Luggage(int capacity) {
        bags = new HashMap<>(capacity);
    }

    Collection<Bag> getBags() {
        return new ArrayList<>(bags.values());
    }

    void addBag(CharSequence line) {
        var lineParts = BAGS_CONTAIN_PATTERN.split(line);

        var bag = getOrCreate(lineParts[0]);
        if (lineParts[1].equals("no other bags.")) {
            return;
        }

        var containsParts = BAGS_CONTAIN_LIST_PATTERN.split(lineParts[1]);
        for (var containsPart : containsParts) {
            var containsBagParts = containsPart.split(" ");

            var quantity = Integer.parseInt(containsBagParts[0]);
            var color = containsBagParts[1] + " " + containsBagParts[2];

            var containedBag = getOrCreate(color);
            bag.addBag(containedBag, quantity);
        }
    }

    private Bag getOrCreate(String color) {
        return bags.computeIfAbsent(color, s -> new Bag(s, new HashMap<>()));
    }
}
