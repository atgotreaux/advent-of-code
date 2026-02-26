package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.RayNavigator;

record RotateColumnOperation(int column, int shift) implements Operation {

    static RotateColumnOperation of(String line) {
        var parts = line.split(" ");
        if (parts.length != 5) {
            throw new IllegalArgumentException("Invalid rotate column operation format: " + line);
        }

        var colParts = parts[2].split("=");
        if (colParts.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid column format in rotate column operation: " + line);
        }
        var col = Integer.parseInt(colParts[1]);

        var shift = Integer.parseInt(parts[4]);

        return new RotateColumnOperation(col, shift);
    }

    RotateColumnOperation {
        if (column < 0) {
            throw new IllegalArgumentException("Invalid column index: " + column);
        }
        if (shift < 0) {
            throw new IllegalArgumentException("Invalid shift value: " + shift);
        }
    }

    @Override
    public void apply(Matrix<Character> matrix) {
        var navigator = new RayNavigator<>(matrix, new Cell(-1, column));
        var originalCol = navigator.collectElements(Direction.SOUTH);

        for (var row = 0; row < matrix.getRowCount(); row++) {
            var shiftRow = (row + shift) % matrix.getRowCount();
            matrix.set(new Cell(shiftRow, column), originalCol.get(row));
        }
    }
}
