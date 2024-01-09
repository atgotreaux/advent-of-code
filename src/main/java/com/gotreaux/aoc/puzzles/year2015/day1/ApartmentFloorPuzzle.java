package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;

@ShellPuzzle(year = 2015, day = 1, title = "Not Quite Lisp")
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        long currentFloor = 0L;

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            char instructionLabel = input.charAt(i);
            Instruction instruction = Instruction.fromLabel(instructionLabel);
            switch (instruction) {
                case UP -> currentFloor++;
                case DOWN -> currentFloor--;
            }
        }

        return currentFloor;
    }

    @Override
    public Integer getPartTwo() throws Exception {
        long currentFloor = 0L;

        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            char instructionLabel = input.charAt(i);
            Instruction instruction = Instruction.fromLabel(instructionLabel);
            switch (instruction) {
                case UP -> currentFloor++;
                case DOWN -> currentFloor--;
            }
            if (currentFloor < 0L) {
                return i + 1;
            }
        }

        throw new RuntimeException("The basement is never reached!");
    }
}
