package com.gotreaux.aoc.puzzles.year2016.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import com.gotreaux.aoc.utils.RelativeDirection;
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
            throws IOException, URISyntaxException, NoSuchElementException, NumberFormatException {
        CardinalDirection direction = CardinalDirection.NORTH;
        Point position = new Point();
        Point firstDupPosition = null;

        Collection<Point> visitedPositions = new ArrayList<>();
        visitedPositions.add(position);

        String input = getInputProvider().getInputString();
        for (String step : INSTRUCTION_SEPARATOR.split(input)) {
            RelativeDirection relativeDirection = RelativeDirection.fromLabel(step.charAt(0));
            direction = direction.turn(relativeDirection);

            int units = Integer.parseInt(step.substring(1));
            for (int i = 0; i < units; i++) {
                position = direction.move(position, 1);
                if (firstDupPosition == null && visitedPositions.contains(position)) {
                    firstDupPosition = position;
                }
                visitedPositions.add(position);
            }
        }

        int shortestPath = Math.abs(position.x) + Math.abs(position.y);

        int firstDupPath = Integer.MAX_VALUE;
        if (firstDupPosition != null) {
            firstDupPath = Math.abs(firstDupPosition.x) + Math.abs(firstDupPosition.y);
        }

        return new PuzzleOutput<>(shortestPath, firstDupPath);
    }
}
