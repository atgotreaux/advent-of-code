package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import com.gotreaux.aoc.puzzles.year2016.day8.Pixel;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Matrix;

record RectOperation(int width, int height) implements Operation {

    static RectOperation of(String line) {
        var parts = line.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid rect operation format: " + line);
        }

        var dimensions = parts[1].split("x");
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Invalid rect operation format: " + line);
        }

        var width = Integer.parseInt(dimensions[0]);
        var height = Integer.parseInt(dimensions[1]);

        return new RectOperation(width, height);
    }

    RectOperation {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Invalid rect operation dimensions: %dx%d".formatted(width, height));
        }
    }

    @Override
    public void apply(Matrix<Character> matrix) {
        for (var row = 0; row < height; row++) {
            for (var col = 0; col < width; col++) {
                matrix.set(new Cell(row, col), Pixel.ON.getLabel());
            }
        }
    }
}
