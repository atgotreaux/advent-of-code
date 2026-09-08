package com.gotreaux.aoc.utils.graph.edge;

public record UnweightedEdge<T>(T from, T to) implements Edge<T> {}
