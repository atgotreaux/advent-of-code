package com.gotreaux.aoc.puzzles.year2021.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.Coordinate;
import java.util.Locale;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class DivePuzzle extends Puzzle {

    public DivePuzzle() {
        super(2021, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var position = new Coordinate(0, 0);

        var aim = 0;
        var positionWithAim = new Coordinate(0, 0);

        for (var line : inputReader.getInputList()) {
            var scanner = new Scanner(line);

            var command = Command.valueOf(scanner.next().toUpperCase(Locale.getDefault()));
            var units = scanner.nextInt();

            scanner.close();

            switch (command) {
                case FORWARD -> {
                    position = position.translate(units, 0);
                    positionWithAim = positionWithAim.translate(units, units * aim);
                }
                case DOWN -> {
                    position = position.translate(0, units);
                    aim += units;
                }
                case UP -> {
                    position = position.translate(0, -units);
                    aim -= units;
                }
            }
        }

        var productOfPosition = position.x() * position.y();
        var productOfPositionWithAim = positionWithAim.x() * positionWithAim.y();

        return new PuzzleOutput<>(productOfPosition, productOfPositionWithAim);
    }
}
