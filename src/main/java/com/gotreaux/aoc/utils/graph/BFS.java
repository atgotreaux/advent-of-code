package com.gotreaux.aoc.utils.graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.jspecify.annotations.Nullable;

public class BFS<T> {

    private final Graph<T> graph;

    public BFS(Graph<T> graph) {
        this.graph = Graph.of(graph);
    }

    public Map<T, Integer> getDistances(T from) {
        return search(from, null);
    }

    public int getDistance(T from, T to) {
        return search(from, to).getOrDefault(to, -1);
    }

    private Map<T, Integer> search(T from, @Nullable T to) {
        Deque<T> queue = new ArrayDeque<>();
        Collection<T> visited = new HashSet<>();
        Map<T, Integer> distances = new HashMap<>();

        queue.push(from);
        visited.add(from);
        distances.put(from, 0);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            int currentDistance = distances.get(current);

            for (var neighbor : graph.getNeighbors(current)) {
                if (visited.add(neighbor)) {
                    distances.put(neighbor, currentDistance + 1);
                    if (neighbor.equals(to)) {
                        return distances;
                    }
                    queue.push(neighbor);
                }
            }
        }

        return distances;
    }
}
