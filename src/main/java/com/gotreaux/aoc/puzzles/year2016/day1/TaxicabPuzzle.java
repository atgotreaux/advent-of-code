package com.gotreaux.aoc.puzzles.year2016.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.RelativeDirection;
import com.gotreaux.aoc.utils.enums.EnumUtils;
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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var direction = CardinalDirection.NORTH;
        var position = new Coordinate(0, 0);
        Coordinate firstDupPosition = null;

        Collection<Coordinate> visitedPositions = new ArrayList<>();
        visitedPositions.add(position);

        var input = inputReader.getInputString();
        for (var step : INSTRUCTION_SEPARATOR.split(input)) {
            var relativeDirection = EnumUtils.of(RelativeDirection.class, step.charAt(0));
            direction = direction.turn(relativeDirection);

            var units = Integer.parseInt(step.substring(1));
            for (var i = 0; i < units; i++) {
                position = position.move(direction, 1);
                if (firstDupPosition == null && visitedPositions.contains(position)) {
                    firstDupPosition = position;
                }
                visitedPositions.add(position);
            }
        }

        var shortestPath = Math.abs(position.x()) + Math.abs(position.y());

        var firstDupPath = Integer.MAX_VALUE;
        if (firstDupPosition != null) {
            firstDupPath = Math.abs(firstDupPosition.x()) + Math.abs(firstDupPosition.y());
        }

        return new PuzzleOutput<>(shortestPath, firstDupPath);
    }
}
