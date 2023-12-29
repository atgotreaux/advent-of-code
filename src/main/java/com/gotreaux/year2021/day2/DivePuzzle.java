package com.gotreaux.year2021.day2;

import com.gotreaux.Puzzle;

import java.awt.Point;
import java.util.Scanner;
import java.util.stream.Stream;

public class DivePuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        DivePuzzle puzzle = new DivePuzzle();

        puzzle.solve();
    }

    private final Point position = new Point();
    private final Point positionWithAim = new Point();
    private int aim;

    public DivePuzzle() throws Exception {
        super();

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                Scanner scanner = new Scanner(line);

                Command command = Command.valueOf(scanner.next().toUpperCase());
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
            });
        }
    }

    @Override
    public Integer getPartOne() {
        return position.x * position.y;
    }

    @Override
    public Integer getPartTwo() {
        return positionWithAim.x * positionWithAim.y;
    }
}
