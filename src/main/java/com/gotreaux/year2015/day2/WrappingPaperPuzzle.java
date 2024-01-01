package com.gotreaux.year2015.day2;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.util.Scanner;
import java.util.stream.Stream;

public class WrappingPaperPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle();

        puzzle.solve();
    }

    private long wrappingPaperOrderTotal;
    private long ribbonOrderTotal;

    public WrappingPaperPuzzle() throws Exception {
        super();

        prepare();
    }

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
