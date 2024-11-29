package com.gotreaux.aoc.puzzles.year2016.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class TaxicabPuzzle extends Puzzle {

    private static final Pattern INSTRUCTION_SEPARATOR = Pattern.compile(", ");

    public TaxicabPuzzle() {
        super(2016, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        CardinalDirection direction = CardinalDirection.NORTH;
        Point position = new Point();
        Point firstDupPosition = null;

        Collection<Point> visitedPositions = new ArrayList<>();
        visitedPositions.add(position);

        String input = inputReader.getInputString();
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
