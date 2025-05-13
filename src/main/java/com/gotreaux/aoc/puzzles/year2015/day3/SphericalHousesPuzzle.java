package com.gotreaux.aoc.puzzles.year2015.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class SphericalHousesPuzzle extends Puzzle {

    public SphericalHousesPuzzle() {
        super(2015, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputString();
        var length = input.length();

        Set<Point> houseDeliveries = new HashSet<>(length);
        Set<Point> assistedHouseDeliveries = new HashSet<>(length);

        var position = new Point();
        houseDeliveries.add(position);

        var santaPosition = new Point();
        var roboSantaPosition = new Point();
        assistedHouseDeliveries.add(santaPosition);

        for (var i = 0; i < length; i++) {
            var direction = CardinalDirection.of(input.charAt(i));

            position = direction.move(position, 1);
            houseDeliveries.add(position);

            if (i % 2 == 0) {
                santaPosition = direction.move(santaPosition, 1);
                assistedHouseDeliveries.add(santaPosition);
            } else {
                roboSantaPosition = direction.move(roboSantaPosition, 1);
                assistedHouseDeliveries.add(roboSantaPosition);
            }
        }

        return new PuzzleOutput<>(houseDeliveries.size(), assistedHouseDeliveries.size());
    }
}
