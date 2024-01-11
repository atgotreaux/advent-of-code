package com.gotreaux.aoc.puzzles.year2016.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

@ShellPuzzle(year = 2016, day = 1, title = "No Time for a Taxicab")
public class TaxicabPuzzle extends Puzzle {

    public TaxicabPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public Integer getPartOne() throws Exception {
        Direction direction = Direction.NORTH;
        Point position = new Point();

        String input = getInputProvider().getInputString();
        for (String step : input.split(", ")) {
            Instruction instruction = Instruction.fromLabel(step.charAt(0));
            int units = Integer.parseInt(step.substring(1));

            direction = direction.turn(instruction);
            position = direction.move(position, units);
        }

        return Math.abs(position.x) + Math.abs(position.y);
    }

    public Integer getPartTwo() throws Exception {
        Direction direction = Direction.NORTH;

        List<Point> visitedPositions = new ArrayList<>();
        Point position = new Point();
        visitedPositions.add(position);

        String input = getInputProvider().getInputString();
        for (String step : input.split(", ")) {
            Instruction instruction = Instruction.fromLabel(step.charAt(0));
            direction = direction.turn(instruction);

            int units = Integer.parseInt(step.substring(1));
            for (int i = 0; i < units; i++) {
                position = direction.move(position, 1);
                if (visitedPositions.contains(position)) {
                    return Math.abs(position.x) + Math.abs(position.y);
                }
                visitedPositions.add(position);
            }
        }

        throw new RuntimeException("No position is visited twice!");
    }
}
