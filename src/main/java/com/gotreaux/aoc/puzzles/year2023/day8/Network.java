package com.gotreaux.aoc.puzzles.year2023.day8;

import com.gotreaux.aoc.utils.MathUtils;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

class Network {
    private final List<Instruction> instructions;
    private final List<Node> nodes;

    Network(List<Instruction> instructions, List<Node> nodes) {
        this.instructions = instructions;
        this.nodes = nodes;
    }

    public long getStepsForNodes(Predicate<Node> startPosition, Predicate<Node> endPosition)
            throws NoSuchElementException {
        List<Node> currentNodes = nodes.stream().filter(startPosition).toList();

        return currentNodes.stream()
                .mapToLong(node -> getStepsForNode(node, endPosition))
                .reduce(1L, MathUtils::lcm);
    }

    private long getStepsForNode(Node startPosition, Predicate<Node> endPosition)
            throws NoSuchElementException {
        long steps = 0L;
        int currentInstructionIndex = 0;

        Node currentNode = startPosition;
        while (!endPosition.test(currentNode)) {
            steps++;

            Instruction nextInstruction = instructions.get(currentInstructionIndex);
            String nextPosition =
                    switch (nextInstruction) {
                        case RIGHT -> currentNode.rightPosition();
                        case LEFT -> currentNode.leftPosition();
                    };

            currentNode =
                    nodes.stream()
                            .filter(node -> node.position().equals(nextPosition))
                            .findFirst()
                            .orElseThrow();

            currentInstructionIndex++;
            if (currentInstructionIndex == instructions.size()) {
                currentInstructionIndex = 0;
            }
        }

        return steps;
    }
}
