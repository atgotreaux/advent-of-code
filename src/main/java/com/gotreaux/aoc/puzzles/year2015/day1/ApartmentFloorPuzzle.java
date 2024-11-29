package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle() {
        super(2015, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int floor = 0;
        int positionBasementReached = Integer.MAX_VALUE;

        String input = inputReader.getInputString();
        for (int i = 0; i < input.length(); i++) {
            Instruction instruction = Instruction.fromLabel(input.charAt(i));
            switch (instruction) {
                case UP -> floor++;
                case DOWN -> floor--;
            }
            if (positionBasementReached == Integer.MAX_VALUE && floor < 0) {
                positionBasementReached = i + 1;
            }
        }

        return new PuzzleOutput<>(floor, positionBasementReached);
    }
}
