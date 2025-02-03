package com.gotreaux.aoc.utils.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.lang.Nullable;

public class BFS {

    private final Map<String, List<String>> adjacencyList = new HashMap<>();

    public BFS(Iterable<Edge> edges) {
        for (Edge edge : edges) {
            adjacencyList.computeIfAbsent(edge.from(), _ -> new ArrayList<>()).add(edge.to());
            adjacencyList.computeIfAbsent(edge.to(), _ -> new ArrayList<>()).add(edge.from());
        }
    }

    public Map<String, Integer> getDistances(String from) {
        return search(from, null);
    }

    public int getDistance(String from, String to) {
        return search(from, to).getOrDefault(to, -1);
    }

    private Map<String, Integer> search(String from, @Nullable String to) {
        Deque<String> queue = new ArrayDeque<>();
        Collection<String> visited = new HashSet<>();
        Map<String, Integer> distances = new HashMap<>();

        queue.push(from);
        visited.add(from);
        distances.put(from, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);

            for (String neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
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
