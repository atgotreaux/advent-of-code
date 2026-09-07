package com.gotreaux.aoc.puzzles.year2015.day19;

import java.util.regex.Pattern;

record Replacement(String from, String to) {

    private static final Pattern PATTERN1 = Pattern.compile(" => ");

    static Replacement of(String line) {
        var parts = PATTERN1.split(line);

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid replacement: %s".formatted(line));
        }

        return new Replacement(parts[0], parts[1]);
    }
}
