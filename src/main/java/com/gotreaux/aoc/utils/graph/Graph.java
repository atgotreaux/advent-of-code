package com.gotreaux.aoc.utils.graph;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedSet;

public class Graph<T> {

    static <T> Graph<T> of(Graph<T> other) {
        var graph = new Graph<T>();

        graph.getAdjacencyList().putAll(other.getAdjacencyList());

        return graph;
    }

    private final Map<T, SequencedSet<T>> adjacencyList = new HashMap<>();

    private Map<T, SequencedSet<T>> getAdjacencyList() {
        return adjacencyList;
    }

    SequencedSet<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new LinkedHashSet<>());
    }

    private void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new LinkedHashSet<>());
    }

    void addDirectedEdge(T from, T to) {
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(to);
    }

    public void addUndirectedEdge(T from, T to) {
        addDirectedEdge(from, to);
        addDirectedEdge(to, from);
    }
}
