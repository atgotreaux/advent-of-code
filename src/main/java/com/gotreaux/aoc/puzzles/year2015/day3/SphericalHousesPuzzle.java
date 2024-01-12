package com.gotreaux.aoc.puzzles.year2015.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

@ShellPuzzle(year = 2015, day = 3, title = "Perfectly Spherical Houses in a Vacuum")
public class SphericalHousesPuzzle extends Puzzle {

    public SphericalHousesPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        Set<Point> houseDeliveries = new HashSet<>();
        Set<Point> assistedHouseDeliveries = new HashSet<>();

        Point currentPosition = new Point();
        houseDeliveries.add(currentPosition);

        Point santaPosition = new Point();
        Point roboSantaPosition = new Point();
        assistedHouseDeliveries.add(santaPosition);

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            Direction direction = Direction.fromLabel(input.charAt(i));

            currentPosition = direction.move(currentPosition);
            houseDeliveries.add(currentPosition);

            if (i % 2 == 0) {
                santaPosition = direction.move(santaPosition);
                assistedHouseDeliveries.add(santaPosition);
            } else {
                roboSantaPosition = direction.move(roboSantaPosition);
                assistedHouseDeliveries.add(roboSantaPosition);
            }
        }

        return new PuzzleOutput<>(houseDeliveries.size(), assistedHouseDeliveries.size());
    }
}