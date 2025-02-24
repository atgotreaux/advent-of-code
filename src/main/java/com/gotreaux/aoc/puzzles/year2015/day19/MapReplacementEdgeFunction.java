package com.gotreaux.aoc.puzzles.year2015.day19;

import com.gotreaux.aoc.utils.graph.Edge;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MapReplacementEdgeFunction implements Function<String, Edge> {

    static final Pattern PATTERN = Pattern.compile("^([a-zA-Z]+) => ([a-zA-Z]+)$");

    @Override
    public Edge apply(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid replacement: %s".formatted(line));
        }

        return new Edge(matcher.group(1), matcher.group(2));
    }
}
