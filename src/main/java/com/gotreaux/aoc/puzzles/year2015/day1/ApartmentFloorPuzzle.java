package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class ApartmentFloorPuzzle extends Puzzle {

    public ApartmentFloorPuzzle() {
        super(2015, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var floor = 0;
        var positionBasementReached = Integer.MAX_VALUE;

        var input = inputReader.getInputString();
        for (var i = 0; i < input.length(); i++) {
            var instruction = EnumUtils.of(Instruction.class, input.charAt(i));
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
