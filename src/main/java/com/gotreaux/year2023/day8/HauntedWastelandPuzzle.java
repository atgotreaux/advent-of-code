package com.gotreaux.year2023.day8;

import com.gotreaux.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class HauntedWastelandPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        HauntedWastelandPuzzle puzzle = new HauntedWastelandPuzzle();

        puzzle.solve();
    }

    private final List<Instruction> instructions = new ArrayList<>();
    private final List<Node> nodes = new ArrayList<>();

    public HauntedWastelandPuzzle() throws Exception {
        super();

        prepare();
    }

    public HauntedWastelandPuzzle(String fileName) throws Exception {
        super(fileName);

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                if (line.matches("^[RL]+$")) {
                    for (int i = 0; i < line.length(); i++) {
                        instructions.add(Instruction.fromLabel(line.charAt(i)));
                    }
                } else if (line.matches("\\w+\\s=\\s\\(\\w+,\\s\\w+\\)")) {
                    String[] nodeParts = line.replace(" = (", ", ")
                            .replace(")", "")
                            .split(", ");
                    nodes.add(new Node(nodeParts[0], nodeParts[1], nodeParts[2]));
                }
            });
        }
    }

    @Override
    public Long getPartOne() throws NoSuchElementException {
        return getStepsForNodes(
                node -> node.position().equals("AAA"),
                node -> node.position().equals("ZZZ")
        );
    }

    @Override
    public Long getPartTwo() throws NoSuchElementException {
        return getStepsForNodes(
                node -> node.position().endsWith("A"),
                node -> node.position().endsWith("Z")
        );
    }

    private long getStepsForNodes(Predicate<Node> startPosition, Predicate<Node> endPosition) throws NoSuchElementException {
        List<Node> currentNodes = nodes.stream()
                .filter(startPosition)
                .toList();

        return currentNodes.stream()
                .mapToLong(node -> getStepsForNode(node, endPosition))
                .reduce(1, (a, b) -> (a * b) / gcd(a, b));
    }

    private long getStepsForNode(Node startPosition, Predicate<Node> endPosition) throws NoSuchElementException {
        long steps = 0;
        int currentInstructionIndex = 0;

        Node currentNode = startPosition;
        while (! endPosition.test(currentNode)) {
            steps++;

            Instruction nextInstruction = instructions.get(currentInstructionIndex);
            String nextPosition = switch (nextInstruction) {
                case RIGHT -> currentNode.rightPosition();
                case LEFT -> currentNode.leftPosition();
            };

            currentNode = nodes.stream()
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

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
