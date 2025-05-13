package com.gotreaux.aoc.puzzles.year2024.day5;

record PageOrderingRule(int before, int after) {

    static PageOrderingRule of(String line) {
        var parts = line.split("\\|");

        return new PageOrderingRule(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }
}
