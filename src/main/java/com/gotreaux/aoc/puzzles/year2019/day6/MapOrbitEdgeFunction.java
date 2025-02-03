package com.gotreaux.aoc.puzzles.year2019.day6;

import com.gotreaux.aoc.utils.graph.Edge;
import java.util.function.Function;

public class MapOrbitEdgeFunction implements Function<String, Edge> {

    @Override
    public Edge apply(String line) {
        String[] parts = line.split("\\)");

        return new Edge(parts[0], parts[1]);
    }
}
