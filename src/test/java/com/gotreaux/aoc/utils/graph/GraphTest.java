package com.gotreaux.aoc.utils.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void of() {
        var original = new Graph<String>();
        original.addDirectedEdge("A", "B");
        original.addUndirectedEdge("B", "C");

        var copy = Graph.of(original);

        assertEquals(original.getNeighbors("A"), copy.getNeighbors("A"));
        assertEquals(original.getNeighbors("B"), copy.getNeighbors("B"));
        assertEquals(original.getNeighbors("C"), copy.getNeighbors("C"));

        copy.addDirectedEdge("D", "E");

        assertTrue(copy.getNeighbors("D").contains("E"));
        assertTrue(original.getNeighbors("D").isEmpty());
    }

    @Test
    void ofEmptyGraph() {
        var copy = Graph.of(new Graph<String>());

        assertTrue(copy.getNeighbors("A").isEmpty());
    }

    @Test
    void addDirectedEdge() {
        var graph = new Graph<String>();
        graph.addDirectedEdge("A", "B");

        var neighborsA = graph.getNeighbors("A");
        var neighborsB = graph.getNeighbors("B");

        assertTrue(neighborsA.contains("B"));
        assertEquals(1, neighborsA.size());
        assertTrue(neighborsB.isEmpty());
    }

    @Test
    void addUndirectedEdge() {
        var graph = new Graph<String>();
        graph.addUndirectedEdge("A", "B");

        var neighborsA = graph.getNeighbors("A");
        var neighborsB = graph.getNeighbors("B");

        assertTrue(neighborsA.contains("B"));
        assertTrue(neighborsB.contains("A"));
    }

    @Test
    void getNeighborsForInvalidVertex() {
        var graph = new Graph<String>();

        assertTrue(graph.getNeighbors("A").isEmpty());
    }

    @Test
    void addMultipleEdges() {
        var graph = new Graph<String>();
        graph.addDirectedEdge("A", "B");
        graph.addDirectedEdge("A", "C");

        var neighbors = graph.getNeighbors("A");

        assertEquals(2, neighbors.size());
        assertTrue(neighbors.contains("B"));
        assertTrue(neighbors.contains("C"));
    }
}
