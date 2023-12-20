package com.gotreaux.year2015.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

public class ApartmentFloorPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle();

        puzzle.solve();
    }

    private long currentFloor = 0;
    private long positionOfEnteringBasement = -1;

    public ApartmentFloorPuzzle() {
        super();
    }

    public ApartmentFloorPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public void prepare() throws Exception {
        String input = getInputProvider().getInputString();
        for (int i = 0; i < input.length(); i++) {
            char instructionLabel = input.charAt(i);
            Instruction instruction = Instruction.fromLabel(instructionLabel);
            switch (instruction) {
                case UP -> currentFloor++;
                case DOWN -> currentFloor--;
            }
            if (currentFloor < 0 && positionOfEnteringBasement < 0) {
                positionOfEnteringBasement = i + 1;
            }
        }
    }

    @Override
    public Long getPartOne() {
        return currentFloor;
    }

    @Override
    public Long getPartTwo() {
        return positionOfEnteringBasement;
    }
}
