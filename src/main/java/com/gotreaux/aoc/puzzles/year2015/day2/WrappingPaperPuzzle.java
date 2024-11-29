package com.gotreaux.aoc.puzzles.year2015.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class WrappingPaperPuzzle extends Puzzle {

    public WrappingPaperPuzzle() {
        super(2015, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int wrappingPaperOrderTotal = 0;
        int ribbonOrderTotal = 0;

        for (String line : inputReader.getInputList()) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter("x");

            int length = scanner.nextInt();
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            scanner.close();

            Present present = new Present(length, width, height);

            wrappingPaperOrderTotal += present.getSurfaceArea() + present.getAreaOfSmallestSide();
            ribbonOrderTotal += present.getSmallestPerimeter() + present.getVolume();
        }

        return new PuzzleOutput<>(wrappingPaperOrderTotal, ribbonOrderTotal);
    }
}
