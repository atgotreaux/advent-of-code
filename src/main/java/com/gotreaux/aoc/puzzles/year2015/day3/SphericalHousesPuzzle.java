package com.gotreaux.aoc.puzzles.year2015.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CardinalDirection;
import java.awt.Point;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class SphericalHousesPuzzle extends Puzzle {

    public SphericalHousesPuzzle() {
        super(2015, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchElementException {
        String input = inputReader.getInputString();
        int length = input.length();

        Set<Point> houseDeliveries = new HashSet<>(length);
        Set<Point> assistedHouseDeliveries = new HashSet<>(length);

        Point position = new Point();
        houseDeliveries.add(position);

        Point santaPosition = new Point();
        Point roboSantaPosition = new Point();
        assistedHouseDeliveries.add(santaPosition);

        for (int i = 0; i < length; i++) {
            CardinalDirection direction = CardinalDirection.fromLabel(input.charAt(i));

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
