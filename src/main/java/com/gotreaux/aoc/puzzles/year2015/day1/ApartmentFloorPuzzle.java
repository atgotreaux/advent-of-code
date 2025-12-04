package com.gotreaux.aoc.puzzles.year2015.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class ApartmentFloorPuzzle extends Puzzle<Integer, Integer> {

    public ApartmentFloorPuzzle() {
        super(2015, 1);
    }

    @Override
    public Integer solvePartOne(InputReader inputReader) {
        var floor = 0;

        var input = inputReader.getInputString();
        for (var i = 0; i < input.length(); i++) {
            var instruction = Instruction.of(input.charAt(i));
            switch (instruction) {
                case UP -> floor++;
                case DOWN -> floor--;
            }
        }

        return floor;
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        var floor = 0;

        var input = inputReader.getInputString();
        for (var i = 0; i < input.length(); i++) {
            var instruction = Instruction.of(input.charAt(i));
            switch (instruction) {
                case UP -> floor++;
                case DOWN -> floor--;
            }
            if (floor < 0) {
                return i + 1;
            }
        }

        throw new IllegalArgumentException("Basement is never reached");
    }
}
