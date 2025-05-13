package com.gotreaux.aoc.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.utils.RelativeDirection;
import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class NetworkTest {
    @Test
    void testEscapeNoRepeats() {
        var directions = List.of(RelativeDirection.RIGHT, RelativeDirection.LEFT);

        var nodes =
                List.of(
                        new Node("AAA", "BBB", "CCC"),
                        new Node("BBB", "DDD", "EEE"),
                        new Node("CCC", "ZZZ", "GGG"),
                        new Node("DDD", "DDD", "DDD"),
                        new Node("EEE", "EEE", "EEE"),
                        new Node("GGG", "GGG", "GGG"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        var network = new Network(directions, nodes);

        Predicate<Node> startPosition = node -> node.position().equals("AAA");
        Predicate<Node> endPosition = node -> node.position().equals("ZZZ");

        assertEquals(2L, network.getStepsForNodes(startPosition, endPosition));
    }

    @Test
    void testEscapeRepeats() {
        var directions =
                List.of(RelativeDirection.LEFT, RelativeDirection.LEFT, RelativeDirection.RIGHT);

        var nodes =
                List.of(
                        new Node("AAA", "BBB", "BBB"),
                        new Node("BBB", "AAA", "ZZZ"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        var network = new Network(directions, nodes);

        Predicate<Node> startPosition = node -> node.position().equals("AAA");
        Predicate<Node> endPosition = node -> node.position().equals("ZZZ");

        assertEquals(6L, network.getStepsForNodes(startPosition, endPosition));
    }

    @Test
    void testEscapeGhostRepeats() {
        var directions =
                List.of(RelativeDirection.LEFT, RelativeDirection.LEFT, RelativeDirection.RIGHT);

        var nodes =
                List.of(
                        new Node("AAA", "BBB", "BBB"),
                        new Node("BBB", "AAA", "ZZZ"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        var network = new Network(directions, nodes);

        Predicate<Node> startPosition =
                node -> node.position().charAt(node.position().length() - 1) == 'A';
        Predicate<Node> endPosition =
                node -> node.position().charAt(node.position().length() - 1) == 'Z';

        assertEquals(6L, network.getStepsForNodes(startPosition, endPosition));
    }
}
