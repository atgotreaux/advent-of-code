package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.RayNavigator;

record RotateRowOperation(int row, int shift) implements Operation {

    static RotateRowOperation of(String line) {
        var parts = line.split(" ");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid rotate row operation format: " + line);
        }

        var rowParts = parts[2].split("=");
        if (rowParts.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid row format in rotate row operation: " + line);
        }
        var row = Integer.parseInt(rowParts[1]);

        var shift = Integer.parseInt(parts[4]);

        return new RotateRowOperation(row, shift);
    }

    RotateRowOperation {
        if (row < 0) {
            throw new IllegalArgumentException("Invalid row index: " + row);
        }
        if (shift < 0) {
            throw new IllegalArgumentException("Invalid shift value: " + shift);
        }
    }

    @Override
    public void apply(Matrix<Character> matrix) {
        var navigator = new RayNavigator<>(matrix, new Cell(row, -1));
        var originalRow = navigator.collectElements(Direction.EAST);

        for (var col = 0; col < matrix.getColCount(); col++) {
            var shiftCol = (col + shift) % matrix.getColCount();
            matrix.set(new Cell(row, shiftCol), originalRow.get(col));
        }
    }
}
