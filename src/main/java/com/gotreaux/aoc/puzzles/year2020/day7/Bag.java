package com.gotreaux.aoc.puzzles.year2020.day7;

import java.util.Map;

record Bag(String color, Map<Bag, Integer> bags) {

    void addBag(Bag bag, int quantity) {
        bags.put(bag, quantity);
    }

    boolean contains(String color) {
        return bags.keySet().stream()
                .anyMatch(bag -> bag.color().equals(color) || bag.contains(color));
    }

    long getBagCount() {
        return bags.entrySet().stream()
                .mapToLong(e -> e.getValue() + e.getKey().getBagCount() * e.getValue())
                .sum();
    }
}
