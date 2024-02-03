package com.gotreaux.aoc.puzzles.year2019.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.RelativeDirection;
import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ShellPuzzle(year = 2019, day = 3, title = "Crossed Wires")
public class CrossedWiresPuzzle extends Puzzle {
    public CrossedWiresPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException, NumberFormatException {
        Map<Point, Integer> positions = new HashMap<>();

        for (String line : getInputProvider().getInputList()) {
            Collection<Point> wirePositions = new ArrayList<>();
            Point position = new Point();
            for (String instruction : line.split(",")) {
                RelativeDirection direction = RelativeDirection.fromLabel(instruction.charAt(0));

                int units = Integer.parseInt(instruction.substring(1));
                for (int i = 0; i < units; i++) {
                    position = direction.move(position, 1);
                    if (!wirePositions.contains(position)) {
                        positions.merge(position, 1, Integer::sum);
                    }
                    wirePositions.add(position);
                }
            }
        }

        int closestIntersection =
                positions.entrySet().stream()
                        .filter(e -> e.getValue() > 1)
                        .mapToInt(e -> Math.abs(e.getKey().x) + Math.abs(e.getKey().y))
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(closestIntersection, 0);
    }
}
