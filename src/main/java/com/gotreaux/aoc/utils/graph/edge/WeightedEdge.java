package com.gotreaux.aoc.utils.graph.edge;

import java.util.function.ToLongBiFunction;

public record WeightedEdge<T>(T from, T to, long weight)
        implements Edge<T>, Comparable<WeightedEdge<T>> {

    public static <T> WeightedEdge<T> of(T from, T to, ToLongBiFunction<T, T> weigher) {
        return new WeightedEdge<>(from, to, weigher.applyAsLong(from, to));
    }

    @Override
    public int compareTo(WeightedEdge<T> o) {
        return Long.compare(weight, o.weight());
    }
}
