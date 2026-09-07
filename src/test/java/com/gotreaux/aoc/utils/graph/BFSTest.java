package com.gotreaux.aoc.utils.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BFSTest {

    @Test
    void getDistance() {
        var graph = new Graph<String>();
        graph.addDirectedEdge("A", "B");
        graph.addDirectedEdge("B", "C");

        var bfs = new BFS<>(graph);

        assertEquals(2, bfs.getDistance("A", "C"));
        assertEquals(1, bfs.getDistance("A", "B"));
        assertEquals(0, bfs.getDistance("A", "A"));
    }

    @Test
    void getDistanceShortestPath() {
        var graph = new Graph<String>();
        graph.addUndirectedEdge("A", "B");
        graph.addUndirectedEdge("B", "C");
        graph.addUndirectedEdge("C", "A");

        var bfs = new BFS<>(graph);

        assertEquals(1, bfs.getDistance("A", "C"));
    }

    @Test
    void getDistanceNotFound() {
        var graph = new Graph<String>();
        graph.addDirectedEdge("A", "B");
        graph.addDirectedEdge("C", "C");

        var bfs = new BFS<>(graph);

        assertEquals(-1, bfs.getDistance("A", "C"));
    }

    @Test
    void getDistances() {
        var graph = new Graph<String>();
        graph.addDirectedEdge("A", "B");
        graph.addDirectedEdge("A", "C");
        graph.addDirectedEdge("B", "D");

        var bfs = new BFS<>(graph);
        var distances = bfs.getDistances("A");

        assertEquals(0, distances.get("A"));
        assertEquals(1, distances.get("B"));
        assertEquals(1, distances.get("C"));
        assertEquals(2, distances.get("D"));
        assertEquals(4, distances.size());
    }
}
