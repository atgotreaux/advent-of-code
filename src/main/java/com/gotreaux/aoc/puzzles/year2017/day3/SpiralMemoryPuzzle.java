package com.gotreaux.aoc.puzzles.year2017.day3;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class SpiralMemoryPuzzle extends Puzzle {

    public SpiralMemoryPuzzle() {
        super(2017, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException, NumberFormatException {
        String input = inputProvider.getInputString();
        int squares = Integer.parseInt(input);

        Map<Point, Integer> positions = new HashMap<>(squares);
        Point position = new Point();
        positions.put(position, 1);

        int firstValueGreaterThanInput = Integer.MIN_VALUE;

        CardinalDirection direction = CardinalDirection.SOUTH;
        for (int i = 1; i < squares; i++) {
            CardinalDirection leftTurn = direction.turn(RelativeDirection.LEFT);
            Point leftPosition = leftTurn.move(position, 1);
            if (positions.containsKey(leftPosition)) {
                position = direction.move(position, 1);
            } else {
                direction = leftTurn;
                position = leftPosition;
            }

            int value = getSumOfNeighbors(positions, position);
            if (firstValueGreaterThanInput == Integer.MIN_VALUE && value > squares) {
                firstValueGreaterThanInput = value;
            }
            positions.put(position, value);
        }

        int manhattanDistance = Math.abs(position.x) + Math.abs(position.y);

        return new PuzzleOutput<>(manhattanDistance, firstValueGreaterThanInput);
    }

    private static int getSumOfNeighbors(Map<Point, Integer> positions, Point position) {
        int sum = 0;

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (x != 0 || y != 0) {
                    Point neighbor = new Point(position.x + x, position.y + y);
                    if (positions.containsKey(neighbor)) {
                        sum += positions.get(neighbor);
                    }
                }
            }
        }

        return sum;
    }
}
