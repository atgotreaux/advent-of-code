package com.gotreaux.year2016.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TaxicabPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        TaxicabPuzzle puzzle = new TaxicabPuzzle();

        puzzle.solve();
    }

    public TaxicabPuzzle() {
        super();
    }

    public TaxicabPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
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

    @Override
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
