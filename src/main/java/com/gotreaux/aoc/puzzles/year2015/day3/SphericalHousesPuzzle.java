package com.gotreaux.aoc.puzzles.year2015.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.cartesian.CardinalDirection;
import com.gotreaux.aoc.utils.cartesian.Point;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class SphericalHousesPuzzle extends Puzzle {

    public SphericalHousesPuzzle() {
        super(2015, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();
        var length = input.length();

        Set<Point> houseDeliveries = new HashSet<>(length);
        Set<Point> assistedHouseDeliveries = new HashSet<>(length);

        var position = new Point(0, 0);
        houseDeliveries.add(position);

        var santaPosition = new Point(0, 0);
        var roboSantaPosition = new Point(0, 0);
        assistedHouseDeliveries.add(santaPosition);

        for (var i = 0; i < length; i++) {
            var direction = EnumUtils.of(CardinalDirection.class, input.charAt(i));

            position = position.move(direction, 1);
            houseDeliveries.add(position);

            if (i % 2 == 0) {
                santaPosition = santaPosition.move(direction, 1);
                assistedHouseDeliveries.add(santaPosition);
            } else {
                roboSantaPosition = roboSantaPosition.move(direction, 1);
                assistedHouseDeliveries.add(roboSantaPosition);
            }
        }

        return new PuzzleOutput<>(houseDeliveries.size(), assistedHouseDeliveries.size());
    }
}
