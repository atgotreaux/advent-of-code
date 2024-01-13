package com.gotreaux.aoc.puzzles.year2023.day8;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2023, day = 8, title = "Haunted Wasteland")
public class HauntedWastelandPuzzle extends Puzzle {

    public HauntedWastelandPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        List<Instruction> instructions = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            if (line.matches("^[RL]+$")) {
                for (int i = 0; i < line.length(); i++) {
                    instructions.add(Instruction.fromLabel(line.charAt(i)));
                }
            } else if (line.matches("\\w+\\s=\\s\\(\\w+,\\s\\w+\\)")) {
                String[] nodeParts = line.replace(" = (", ", ").replace(")", "").split(", ");
                nodes.add(new Node(nodeParts[0], nodeParts[1], nodeParts[2]));
            }
        }

        Network network = new Network(instructions, nodes);

        long escapeWasteland =
                network.getStepsForNodes(
                        node -> node.position().equals("AAA"),
                        node -> node.position().equals("ZZZ"));

        long ghostsEscapeWasteland =
                network.getStepsForNodes(
                        node -> node.position().endsWith("A"),
                        node -> node.position().endsWith("Z"));

        return new PuzzleOutput<>(escapeWasteland, ghostsEscapeWasteland);
    }
}
