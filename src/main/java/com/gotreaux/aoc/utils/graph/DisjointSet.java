package com.gotreaux.aoc.utils.graph;

import com.gotreaux.aoc.utils.graph.edge.Edge;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T> {

    private final Map<T, T> parents = new HashMap<>();
    private final Map<T, Integer> ranks = new HashMap<>();

    public DisjointSet(Iterable<T> elements) {
        elements.forEach(this::find);
    }

    int getRank(T element) {
        return ranks.getOrDefault(find(element), 1);
    }

    public Collection<Integer> getRanks() {
        return ranks.values();
    }

    public int getRankCount() {
        return ranks.size();
    }

    T find(T element) {
        var parent = parents.putIfAbsent(element, element);

        if (parent == null) {
            ranks.put(element, 1);
            return element;
        }

        if (parent.equals(element)) {
            return element;
        }

        var root = find(parent);
        parents.put(element, root);

        return root;
    }

    public boolean union(Edge<T> edge) {
        return union(edge.from(), edge.to());
    }

    private boolean union(T left, T right) {
        var leftRoot = find(left);
        var rightRoot = find(right);

        if (leftRoot.equals(rightRoot)) {
            return false;
        }

        var leftRank = getRank(leftRoot);
        var rightRank = getRank(rightRoot);

        var root = leftRank >= rightRank ? leftRoot : rightRoot;
        var merged = leftRank >= rightRank ? rightRoot : leftRoot;

        parents.put(merged, root);
        ranks.remove(merged);
        ranks.put(root, leftRank + rightRank);

        return true;
    }
}
