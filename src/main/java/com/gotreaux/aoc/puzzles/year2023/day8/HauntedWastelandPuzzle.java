package com.gotreaux.aoc.puzzles.year2023.day8;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@ShellPuzzle(year = 2023, day = 8, title = "Haunted Wasteland")
public class HauntedWastelandPuzzle extends Puzzle {

    private static final Pattern DIRECTION_LINE = Pattern.compile("^[RL]+$");
    private static final Pattern NODE_LINE = Pattern.compile("\\w+\\s=\\s\\(\\w+,\\s\\w+\\)");
    private static final Pattern NODE_DELIM = Pattern.compile(", ");

    public HauntedWastelandPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve()
            throws IOException,
                    URISyntaxException,
                    NoSuchElementException,
                    IllegalArgumentException {
        List<RelativeDirection> directions = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            if (DIRECTION_LINE.matcher(line).matches()) {
                for (int i = 0; i < line.length(); i++) {
                    directions.add(RelativeDirection.fromLabel(line.charAt(i)));
                }
            } else if (NODE_LINE.matcher(line).matches()) {
                String[] nodeParts = NODE_DELIM.split(line.replace(" = (", ", ").replace(")", ""));
                nodes.add(new Node(nodeParts[0], nodeParts[1], nodeParts[2]));
            }
        }

        Network network = new Network(directions, nodes);

        long escapeWasteland =
                network.getStepsForNodes(
                        node -> node.position().equals("AAA"),
                        node -> node.position().equals("ZZZ"));

        long ghostsEscapeWasteland =
                network.getStepsForNodes(
                        node -> node.position().charAt(node.position().length() - 1) == 'A',
                        node -> node.position().charAt(node.position().length() - 1) == 'Z');

        return new PuzzleOutput<>(escapeWasteland, ghostsEscapeWasteland);
    }
}
