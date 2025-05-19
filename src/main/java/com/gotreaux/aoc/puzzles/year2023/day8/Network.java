package com.gotreaux.aoc.puzzles.year2023.day8;

import com.gotreaux.aoc.utils.MathUtils;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

class Network {
    private final List<RelativeDirection> directions;
    private final List<Node> nodes;

    Network(Collection<RelativeDirection> directions, Collection<Node> nodes) {
        this.directions = List.copyOf(directions);
        this.nodes = List.copyOf(nodes);
    }

    long getStepsForNodes(Predicate<Node> startPosition, Predicate<Node> endPosition) {
        var currentNodes = nodes.stream().filter(startPosition).toList();

        return currentNodes.stream()
                .mapToLong(node -> getStepsForNode(node, endPosition))
                .reduce(1L, MathUtils::lcm);
    }

    private long getStepsForNode(Node startPosition, Predicate<Node> endPosition) {
        var steps = 0L;
        var currentDirectionIndex = 0;

        var currentNode = startPosition;
        while (!endPosition.test(currentNode)) {
            steps++;

            var nextDirection = directions.get(currentDirectionIndex);
            var nextPosition =
                    switch (nextDirection) {
                        case RIGHT -> currentNode.rightPosition();
                        case LEFT -> currentNode.leftPosition();
                        default ->
                                throw new IllegalArgumentException(
                                        "Unsupported direction! '%s'"
                                                .formatted(nextDirection.getLabel()));
                    };

            currentNode =
                    nodes.stream()
                            .filter(node -> node.position().equals(nextPosition))
                            .findFirst()
                            .orElseThrow();

            currentDirectionIndex = (currentDirectionIndex + 1) % directions.size();
        }

        return steps;
    }
}
