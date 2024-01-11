package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;

@ShellPuzzle(year = 2015, day = 1, title = "Not Quite Lisp")
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int currentFloor = 0;
        int positionBasementReached = Integer.MAX_VALUE;

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            char instructionLabel = input.charAt(i);
            Instruction instruction = Instruction.fromLabel(instructionLabel);
            switch (instruction) {
                case UP -> currentFloor++;
                case DOWN -> currentFloor--;
            }
            if (positionBasementReached == Integer.MAX_VALUE && currentFloor < 0) {
                positionBasementReached = i + 1;
            }
        }

        return new PuzzleOutput<>(currentFloor, positionBasementReached);
    }
}
