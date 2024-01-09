package com.gotreaux.aoc.puzzles.year2021.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2021, day = 2, title = "Dive!")
public class DivePuzzle extends Puzzle {

    private final Point position = new Point();
    private final Point positionWithAim = new Point();
    private int aim;

    public DivePuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
                        Scanner scanner = new Scanner(line);

                        Command command =
                                Command.valueOf(scanner.next().toUpperCase(Locale.getDefault()));
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
