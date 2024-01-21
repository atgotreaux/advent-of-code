package com.gotreaux.aoc.puzzles.year2016.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@ShellPuzzle(year = 2016, day = 1, title = "No Time for a Taxicab")
public class TaxicabPuzzle extends Puzzle {

    private static final Pattern INSTRUCTION_SEPARATOR = Pattern.compile(", ");

    public TaxicabPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        Direction direction = Direction.NORTH;
        Point position = new Point();
        Point firstDuplicatePosition = null;

        Collection<Point> visitedPositions = new ArrayList<>();
        visitedPositions.add(position);

        String input = getInputProvider().inputString();
        for (String step : INSTRUCTION_SEPARATOR.split(input)) {
            Instruction instruction = Instruction.fromLabel(step.charAt(0));
            direction = direction.turn(instruction);

            int units = Character.digit(step.charAt(1), 10);
            for (int i = 0; i < units; i++) {
                position = direction.move(position, 1);
                if (firstDuplicatePosition == null && visitedPositions.contains(position)) {
                    firstDuplicatePosition = position;
                }
                visitedPositions.add(position);
            }
        }

        int shortestPath = Math.abs(position.x) + Math.abs(position.y);

        int firstDuplicatePath = Integer.MAX_VALUE;
        if (firstDuplicatePosition != null) {
            firstDuplicatePath =
                    Math.abs(firstDuplicatePosition.x) + Math.abs(firstDuplicatePosition.y);
        }

        return new PuzzleOutput<>(shortestPath, firstDuplicatePath);
    }
}
