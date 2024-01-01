package com.gotreaux.year2015.day3;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class SphericalHousesPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle();

        puzzle.solve();
    }

    public SphericalHousesPuzzle() {
        super();
    }

    public SphericalHousesPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Integer getPartOne() throws Exception {
        Set<Point> houseDeliveries = new HashSet<>();

        Point currentPosition = new Point();
        houseDeliveries.add(currentPosition);

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            Direction direction = Direction.fromLabel(input.charAt(i));

            currentPosition = direction.move(currentPosition);
            houseDeliveries.add(currentPosition);
        }

        return houseDeliveries.size();
    }

    @Override
    public Integer getPartTwo() throws Exception {
        Set<Point> assistedHouseDeliveries = new HashSet<>();

        Point santaPosition = new Point();
        Point roboSantaPosition = new Point();
        assistedHouseDeliveries.add(santaPosition);

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            char directionLabel = input.charAt(i);
            Direction direction = Direction.fromLabel(directionLabel);

            if (i % 2 == 0) {
                santaPosition = direction.move(santaPosition);
                assistedHouseDeliveries.add(santaPosition);
            } else {
                roboSantaPosition = direction.move(roboSantaPosition);
                assistedHouseDeliveries.add(roboSantaPosition);
            }
        }

        return assistedHouseDeliveries.size();
    }
}
