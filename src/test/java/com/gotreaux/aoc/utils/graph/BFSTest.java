package com.gotreaux.aoc.utils.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2019.day6.MapOrbitEdgeFunction;
import com.gotreaux.aoc.puzzles.year2019.day6.UniversalOrbitMapPuzzle;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BFSTest {

    @ParameterizedTest
    @MethodSource("provideGetDistances")
    void getDistances(
            Class<Puzzle> puzzleClass,
            String fileName,
            Function<String, Edge> edgeFunction,
            String from,
            int expectedDistances)
            throws Exception {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass, fileName);

        Collection<Edge> edges = inputReader.getInputList().stream().map(edgeFunction).toList();

        BFS bfs = new BFS(edges);

        int distances = bfs.getDistances(from).values().stream().mapToInt(Integer::intValue).sum();

        assertEquals(expectedDistances, distances);
    }

    @ParameterizedTest
    @MethodSource("provideGetDistance")
    void getDistance(
            Class<Puzzle> puzzleClass,
            String fileName,
            Function<String, Edge> edgeFunction,
            String from,
            String to,
            int expectedDistance)
            throws Exception {
        InputReader inputReader = new ResourceInputReader<>(puzzleClass, fileName);

        Collection<Edge> edges = inputReader.getInputList().stream().map(edgeFunction).toList();

        BFS bfs = new BFS(edges);

        int distance = bfs.getDistance(from, to);

        assertEquals(expectedDistance, distance);
    }

    private static Stream<Arguments> provideGetDistances() {
        return Stream.of(
                Arguments.of(
                        UniversalOrbitMapPuzzle.class,
                        "ExampleOne.txt",
                        new MapOrbitEdgeFunction(),
                        "COM",
                        42));
    }

    private static Stream<Arguments> provideGetDistance() {
        return Stream.of(
                Arguments.of(
                        UniversalOrbitMapPuzzle.class,
                        "ExampleTwo.txt",
                        new MapOrbitEdgeFunction(),
                        "YOU",
                        "SAN",
                        6));
    }
}
