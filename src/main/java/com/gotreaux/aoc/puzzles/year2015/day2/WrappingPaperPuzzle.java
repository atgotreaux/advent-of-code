package com.gotreaux.aoc.puzzles.year2015.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class WrappingPaperPuzzle extends Puzzle {

    public WrappingPaperPuzzle() {
        super(2015, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var presents = inputReader.getInputStream().map(Present::of).toList();

        var wrappingPaperOrderTotal =
                presents.stream()
                        .mapToInt(
                                present ->
                                        present.getSurfaceArea() + present.getAreaOfSmallestSide())
                        .sum();

        var ribbonOrderTotal =
                presents.stream()
                        .mapToInt(present -> present.getSmallestPerimeter() + present.getVolume())
                        .sum();

        return new PuzzleOutput<>(wrappingPaperOrderTotal, ribbonOrderTotal);
    }
}
