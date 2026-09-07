package com.gotreaux.aoc.puzzles.year2019.day6;

record Orbit(String primary, String satellite) {

    static Orbit of(String line) {
        var parts = line.split("\\)");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid orbit line: " + line);
        }

        return new Orbit(parts[0], parts[1]);
    }
}
