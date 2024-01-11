package com.gotreaux.aoc.puzzles.year2015.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;

@ShellPuzzle(year = 2015, day = 2, title = "I Was Told There Would Be No Math")
public class WrappingPaperPuzzle extends Puzzle {

    public WrappingPaperPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int wrappingPaperOrderTotal = 0;
        int ribbonOrderTotal = 0;

        for (String line : getInputProvider().getInputList()) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("x");

            int length = scanner.nextInt();
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            Present present = new Present(length, width, height);

            wrappingPaperOrderTotal += present.getSurfaceArea() + present.getAreaOfSmallestSide();
            ribbonOrderTotal += present.getSmallestPerimeter() + present.getVolume();
        }

        return new PuzzleOutput<>(wrappingPaperOrderTotal, ribbonOrderTotal);
    }
}
