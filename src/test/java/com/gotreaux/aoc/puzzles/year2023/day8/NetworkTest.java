package com.gotreaux.aoc.puzzles.year2023.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class NetworkTest {
    @Test
    void testEscapeNoRepeats() {
        List<Instruction> instructions = List.of(Instruction.RIGHT, Instruction.LEFT);

        List<Node> nodes =
                List.of(
                        new Node("AAA", "BBB", "CCC"),
                        new Node("BBB", "DDD", "EEE"),
                        new Node("CCC", "ZZZ", "GGG"),
                        new Node("DDD", "DDD", "DDD"),
                        new Node("EEE", "EEE", "EEE"),
                        new Node("GGG", "GGG", "GGG"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        Network network = new Network(instructions, nodes);

        Predicate<Node> startPosition = node -> node.position().equals("AAA");
        Predicate<Node> endPosition = node -> node.position().equals("ZZZ");

        assertEquals(2L, network.getStepsForNodes(startPosition, endPosition));
    }

    @Test
    void testEscapeRepeats() {
        List<Instruction> instructions =
                List.of(Instruction.LEFT, Instruction.LEFT, Instruction.RIGHT);

        List<Node> nodes =
                List.of(
                        new Node("AAA", "BBB", "BBB"),
                        new Node("BBB", "AAA", "ZZZ"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        Network network = new Network(instructions, nodes);

        Predicate<Node> startPosition = node -> node.position().equals("AAA");
        Predicate<Node> endPosition = node -> node.position().equals("ZZZ");

        assertEquals(6L, network.getStepsForNodes(startPosition, endPosition));
    }

    @Test
    void testEscapeGhostRepeats() {
        List<Instruction> instructions =
                List.of(Instruction.LEFT, Instruction.LEFT, Instruction.RIGHT);

        List<Node> nodes =
                List.of(
                        new Node("AAA", "BBB", "BBB"),
                        new Node("BBB", "AAA", "ZZZ"),
                        new Node("ZZZ", "ZZZ", "ZZZ"));

        Network network = new Network(instructions, nodes);

        Predicate<Node> startPosition = node -> node.position().endsWith("A");
        Predicate<Node> endPosition = node -> node.position().endsWith("Z");

        assertEquals(6L, network.getStepsForNodes(startPosition, endPosition));
    }
}
