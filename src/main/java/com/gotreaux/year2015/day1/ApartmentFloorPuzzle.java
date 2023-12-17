package com.gotreaux.year2015.day1;

import com.gotreaux.Puzzle;

import java.nio.file.Files;
import java.util.stream.Stream;

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

    public ApartmentFloorPuzzle(String filename) {
        super(filename);
    }

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = Files.lines(getInput())) {
            lines.forEach(line -> {
                for (int i = 0; i < line.length(); i++) {
                    char instructionLabel = line.charAt(i);
                    Instruction instruction = Instruction.fromLabel(instructionLabel);
                    switch (instruction) {
                        case UP -> currentFloor++;
                        case DOWN -> currentFloor--;
                    }
                    if (currentFloor < 0 && positionOfEnteringBasement < 0) {
                        positionOfEnteringBasement = i + 1;
                    }
                }
            });
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
