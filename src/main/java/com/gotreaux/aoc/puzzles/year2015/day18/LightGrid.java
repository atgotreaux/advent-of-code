package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class LightGrid {

    private static final char ON = '#';
    private static final char OFF = '.';

    private final Matrix<Character> matrix;
    private final List<Point> stuckLights;

    LightGrid(Matrix<Character> matrix) {
        this(matrix, new ArrayList<>(0));
    }

    LightGrid(Matrix<Character> matrix, Collection<Point> stuckLights) {
        this.matrix = matrix;
        this.stuckLights = stuckLights.stream().toList();

        for (var light : stuckLights) {
            matrix.set(light.x, light.y, ON);
        }
    }

    LightGrid animate() {
        List<String> result = new ArrayList<>(matrix.getRowCount());

        for (var row = 0; row < matrix.getRowCount(); row++) {
            var resultRow = new StringBuilder(matrix.getColCount());
            for (var col = 0; col < matrix.getColCount(); col++) {
                resultRow.append(getNextState(row, col));
            }
            result.add(resultRow.toString());
        }

        return new LightGrid(MatrixFactory.ofChars(result), stuckLights);
    }

    private char getNextState(int row, int col) {
        if (stuckLights.contains(new Point(row, col))) {
            return ON;
        }
        var neighbors = getNeighboringLightCount(row, col);
        if (matrix.get(row, col) == ON) {
            return (neighbors == 2L || neighbors == 3L) ? ON : OFF;
        }
        return neighbors == 3L ? ON : OFF;
    }

    private long getNeighboringLightCount(int row, int col) {
        return Arrays.stream(matrix.neighbors(row, col, Direction.values()))
                .filter(c -> c == ON)
                .count();
    }

    int getLightCount() {
        var count = 0;

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                if (matrix.get(row, col) == ON) {
                    count++;
                }
            }
        }

        return count;
    }
}
