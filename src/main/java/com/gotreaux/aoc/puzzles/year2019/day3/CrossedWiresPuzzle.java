package com.gotreaux.aoc.puzzles.year2019.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CrossedWiresPuzzle extends Puzzle {

    public CrossedWiresPuzzle() {
        super(2019, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

        List<Point> firstWirePositions = getWirePositions(input.getFirst());
        List<Point> lastWirePositions = getWirePositions(input.getLast());

        Collection<Point> intersections =
                firstWirePositions.stream().filter(lastWirePositions::contains).toList();

        int closestIntersectionDistance =
                intersections.stream()
                        .mapToInt(position -> Math.abs(position.x) + Math.abs(position.y))
                        .filter(i -> i > 0)
                        .min()
                        .orElseThrow();

        int closestIntersectionSteps =
                intersections.stream()
                        .mapToInt(p -> firstWirePositions.indexOf(p) + lastWirePositions.indexOf(p))
                        .filter(i -> i > 0)
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(closestIntersectionDistance, closestIntersectionSteps);
    }

    private static List<Point> getWirePositions(String line) throws NumberFormatException {
        String[] instructions = line.split(",");

        List<Point> positions = new ArrayList<>(instructions.length);
        Point position = new Point();
        positions.add(position);

        for (String instruction : instructions) {
            RelativeDirection direction = RelativeDirection.fromLabel(instruction.charAt(0));

            int units = Integer.parseInt(instruction.substring(1));
            for (int i = 0; i < units; i++) {
                position = direction.move(position, 1);
                positions.add(position);
            }
        }

        return positions;
    }
}
