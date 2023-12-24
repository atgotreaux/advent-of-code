package com.gotreaux.year2015.day2;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

import java.util.Arrays;
import java.util.Collections;
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
            lines.forEach(line -> {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter("x");

                long length = scanner.nextLong();
                long width = scanner.nextLong();
                long height = scanner.nextLong();

                scanner.close();

                wrappingPaperOrderTotal += getSurfaceArea(length, width, height) + getAreaOfSmallestSide(length, width, height);

                ribbonOrderTotal += getSmallestPerimeter(length, width, height) + getCubicFeet(length, width, height);
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

    private long getSurfaceArea(long length, long width, long height) {
        return (2 * length * width) + (2 * width * height) + (2 * height * length);
    }

    private long getAreaOfSmallestSide(long length, long width, long height) {
        return Collections.min(Arrays.asList(length * width, width * height, height * length));
    }

    private long getSmallestPerimeter(long length, long width, long height) {
        return Collections.min(Arrays.asList(2 * (length + width), 2 * (width + height), 2 * (height + length)));
    }

    private long getCubicFeet(long length, long width, long height) {
        return length * width * height;
    }
}
