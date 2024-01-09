package com.gotreaux.aoc.puzzles.year2015.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2015, day = 2, title = "I Was Told There Would Be No Math")
public class WrappingPaperPuzzle extends Puzzle {

    private long wrappingPaperOrderTotal;
    private long ribbonOrderTotal;

    public WrappingPaperPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(
                    line -> {
                        Scanner scanner = new Scanner(line);
                        scanner.useDelimiter("x");

                        Present present =
                                new Present(
                                        scanner.nextLong(), scanner.nextLong(), scanner.nextLong());

                        scanner.close();

                        wrappingPaperOrderTotal +=
                                present.getSurfaceArea() + present.getAreaOfSmallestSide();

                        ribbonOrderTotal += present.getSmallestPerimeter() + present.getVolume();
                    });
        }
    }

    @Override
    public Long getPartOne() {
        return wrappingPaperOrderTotal;
    }

    @Override
    public Long getPartTwo() {
        return ribbonOrderTotal;
    }
}
