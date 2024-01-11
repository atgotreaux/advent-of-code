package com.gotreaux.aoc.puzzles.year2021.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.Locale;
import java.util.Scanner;

@ShellPuzzle(year = 2021, day = 2, title = "Dive!")
public class DivePuzzle extends Puzzle {

    public DivePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        Point position = new Point();

        int aim = 0;
        Point positionWithAim = new Point();

        for (String line : getInputProvider().getInputList()) {
            Scanner scanner = new Scanner(line);

            Command command = Command.valueOf(scanner.next().toUpperCase(Locale.getDefault()));
            int units = scanner.nextInt();

            scanner.close();

            switch (command) {
                case FORWARD:
                    position.translate(units, 0);
                    positionWithAim.translate(units, units * aim);
                    break;
                case DOWN:
                    position.translate(0, units);
                    aim += units;
                    break;
                case UP:
                    position.translate(0, -units);
                    aim -= units;
            }
        }

        int productOfPosition = position.x * position.y;
        int productOfPositionWithAim = positionWithAim.x * positionWithAim.y;

        return new PuzzleOutput<>(productOfPosition, productOfPositionWithAim);
    }
}
