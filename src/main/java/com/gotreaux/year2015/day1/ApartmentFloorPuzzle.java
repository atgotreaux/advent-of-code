package com.gotreaux.year2015.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

public class ApartmentFloorPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        puzzle.solve();
    }

    public ApartmentFloorPuzzle() {
        super();
    }

    public ApartmentFloorPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        long currentFloor = 0L;

        String input = getInputProvider().getInputString();
        for (char instructionLabel : input.toCharArray()) {
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
