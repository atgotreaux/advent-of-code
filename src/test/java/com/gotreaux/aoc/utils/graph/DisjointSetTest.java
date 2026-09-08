package com.gotreaux.aoc.utils.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.utils.graph.edge.Edge;
import com.gotreaux.aoc.utils.graph.edge.UnweightedEdge;
import java.util.List;
import org.junit.jupiter.api.Test;

class DisjointSetTest {

    @Test
    void find() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C"));

        assertEquals("A", disjointSet.find("A"));
        assertEquals("B", disjointSet.find("B"));
        assertEquals("C", disjointSet.find("C"));
    }

    @Test
    void findAfterUnion() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C"));
        disjointSet.union(edge("A", "B"));

        assertEquals(disjointSet.find("A"), disjointSet.find("B"));
        assertEquals("C", disjointSet.find("C"));
    }

    @Test
    void findAfterChainedUnions() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C", "D"));
        disjointSet.union(edge("A", "B"));
        disjointSet.union(edge("C", "D"));
        disjointSet.union(edge("B", "D"));

        var root = disjointSet.find("A");

        assertEquals(root, disjointSet.find("B"));
        assertEquals(root, disjointSet.find("C"));
        assertEquals(root, disjointSet.find("D"));
    }

    @Test
    void findForUnknownElement() {
        var disjointSet = new DisjointSet<>(List.of("A"));

        assertEquals("Z", disjointSet.find("Z"));
        assertEquals(2, disjointSet.getRankCount());
    }

    @Test
    void findForDuplicateElements() {
        var disjointSet = new DisjointSet<>(List.of("A", "A", "B"));

        assertEquals("A", disjointSet.find("A"));
        assertEquals(2, disjointSet.getRankCount());
    }

    @Test
    void getRank() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C"));

        assertEquals(1, disjointSet.getRank("A"));

        disjointSet.union(edge("A", "B"));

        assertEquals(2, disjointSet.getRank("A"));
        assertEquals(2, disjointSet.getRank("B"));
        assertEquals(1, disjointSet.getRank("C"));
    }

    @Test
    void getRankSumsMergedComponents() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C", "D", "E"));
        disjointSet.union(edge("A", "B"));
        disjointSet.union(edge("A", "C"));
        disjointSet.union(edge("D", "E"));
        disjointSet.union(edge("C", "E"));

        assertEquals(5, disjointSet.getRank("A"));
        assertEquals(5, disjointSet.getRank("E"));
    }

    @Test
    void getRankForUnknownElement() {
        var disjointSet = new DisjointSet<>(List.of("A"));

        assertEquals(1, disjointSet.getRank("Z"));
    }

    @Test
    void getRanks() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C", "D", "E"));

        assertEquals(List.of(1, 1, 1, 1, 1), sortedRanks(disjointSet));

        disjointSet.union(edge("A", "B"));
        disjointSet.union(edge("B", "C"));
        disjointSet.union(edge("D", "E"));

        assertEquals(List.of(2, 3), sortedRanks(disjointSet));
    }

    @Test
    void getRanksForEmptyElements() {
        var disjointSet = new DisjointSet<>(List.<String>of());

        assertTrue(disjointSet.getRanks().isEmpty());
    }

    @Test
    void getRankCount() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C"));

        assertEquals(3, disjointSet.getRankCount());

        disjointSet.union(edge("A", "B"));

        assertEquals(2, disjointSet.getRankCount());

        disjointSet.union(edge("B", "C"));

        assertEquals(1, disjointSet.getRankCount());
    }

    @Test
    void getRankCountForEmptyElements() {
        var disjointSet = new DisjointSet<>(List.<String>of());

        assertEquals(0, disjointSet.getRankCount());
    }

    @Test
    void union() {
        var disjointSet = new DisjointSet<>(List.of("A", "B"));

        assertTrue(disjointSet.union(edge("A", "B")));
        assertEquals(disjointSet.find("A"), disjointSet.find("B"));
        assertEquals(1, disjointSet.getRankCount());
    }

    @Test
    void unionConnectedElements() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C"));
        disjointSet.union(edge("A", "B"));
        disjointSet.union(edge("B", "C"));

        assertFalse(disjointSet.union(edge("A", "C")));
        assertEquals(1, disjointSet.getRankCount());
        assertEquals(3, disjointSet.getRank("A"));
    }

    @Test
    void unionSameElement() {
        var disjointSet = new DisjointSet<>(List.of("A"));

        assertFalse(disjointSet.union(edge("A", "A")));
        assertEquals(1, disjointSet.getRankCount());
    }

    @Test
    void unionUnknownElements() {
        var disjointSet = new DisjointSet<>(List.of("A"));

        assertTrue(disjointSet.union(edge("Y", "Z")));
        assertEquals(2, disjointSet.getRankCount());
        assertEquals(List.of(1, 2), sortedRanks(disjointSet));
    }

    @Test
    void unionRootsLargerComponent() {
        var disjointSet = new DisjointSet<>(List.of("A", "B", "C", "D"));
        disjointSet.union(edge("A", "B"));
        disjointSet.union(edge("A", "C"));
        disjointSet.union(edge("D", "A"));

        assertEquals("A", disjointSet.find("D"));
        assertEquals(List.of(4), sortedRanks(disjointSet));
    }

    private static Edge<String> edge(String from, String to) {
        return new UnweightedEdge<>(from, to);
    }

    private static List<Integer> sortedRanks(DisjointSet<String> disjointSet) {
        return disjointSet.getRanks().stream().sorted().toList();
    }
}
