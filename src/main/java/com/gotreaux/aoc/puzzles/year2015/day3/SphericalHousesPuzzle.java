package com.gotreaux.aoc.puzzles.year2015.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import com.gotreaux.aoc.utils.Coordinate;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class SphericalHousesPuzzle extends Puzzle<Integer, Integer> {

    public SphericalHousesPuzzle() {
        super(2015, 3);
    }

    @Override
    public Integer solvePartOne(InputReader inputReader) {
        var input = inputReader.getInputString();
        var length = input.length();

        Set<Coordinate> houseDeliveries = new HashSet<>(length);

        var position = new Coordinate(0, 0);
        houseDeliveries.add(position);

        for (var i = 0; i < length; i++) {
            var direction = CardinalDirection.of(input.charAt(i));

            position = position.move(direction, 1);
            houseDeliveries.add(position);
        }

        return houseDeliveries.size();
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        var input = inputReader.getInputString();
        var length = input.length();

        Set<Coordinate> houseDeliveries = new HashSet<>(length);

        var santaPosition = new Coordinate(0, 0);
        var roboSantaPosition = new Coordinate(0, 0);
        houseDeliveries.add(santaPosition);

        for (var i = 0; i < length; i++) {
            var direction = CardinalDirection.of(input.charAt(i));

            if (i % 2 == 0) {
                santaPosition = santaPosition.move(direction, 1);
                houseDeliveries.add(santaPosition);
            } else {
                roboSantaPosition = roboSantaPosition.move(direction, 1);
                houseDeliveries.add(roboSantaPosition);
            }
        }

        return houseDeliveries.size();
    }
}
