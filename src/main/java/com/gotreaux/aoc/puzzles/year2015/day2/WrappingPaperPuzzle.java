package com.gotreaux.aoc.puzzles.year2015.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class WrappingPaperPuzzle extends Puzzle<Integer, Integer> {

    public WrappingPaperPuzzle() {
        super(2015, 2);
    }

    @Override
    public Integer solvePartOne(InputReader inputReader) {
        return inputReader
                .getInputStream()
                .map(Present::of)
                .mapToInt(present -> present.getSurfaceArea() + present.getAreaOfSmallestSide())
                .sum();
    }

    @Override
    public Integer solvePartTwo(InputReader inputReader) {
        return inputReader
                .getInputStream()
                .map(Present::of)
                .mapToInt(present -> present.getSmallestPerimeter() + present.getVolume())
                .sum();
    }
}
