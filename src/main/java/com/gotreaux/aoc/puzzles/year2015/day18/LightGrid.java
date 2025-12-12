package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.Neighbors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class LightGrid {

    private static final char ON = '#';
    private static final char OFF = '.';

    private final Matrix<Character> matrix;
    private final List<Coordinate> stuckLights;

    LightGrid(Matrix<Character> matrix) {
        this(matrix, new ArrayList<>(0));
    }

    LightGrid(Matrix<Character> matrix, Collection<Coordinate> stuckLights) {
        this.matrix = matrix;
        this.stuckLights = stuckLights.stream().toList();

        stuckLights.forEach(light -> matrix.set(light, ON));
    }

    LightGrid animate() {
        var result = matrix.copy();

        matrix.forEach(coordinate -> result.set(coordinate, getNextState(coordinate)));

        return new LightGrid(result, stuckLights);
    }

    private char getNextState(Coordinate coordinate) {
        if (stuckLights.contains(coordinate)) {
            return ON;
        }
        var neighbors = getNeighboringLightCount(coordinate);
        if (matrix.get(coordinate) == ON) {
            return (neighbors == 2L || neighbors == 3L) ? ON : OFF;
        }
        return neighbors == 3L ? ON : OFF;
    }

    private long getNeighboringLightCount(Coordinate coordinate) {
        return Neighbors.collectElements(matrix, coordinate, Direction.allOf()).stream()
                .filter(c -> c == ON)
                .count();
    }

    int getLightCount() {
        return Math.toIntExact(matrix.count(ON));
    }
}
