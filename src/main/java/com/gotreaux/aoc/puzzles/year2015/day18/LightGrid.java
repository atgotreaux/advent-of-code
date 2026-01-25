package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.CellValue;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class LightGrid {

    private final Matrix<Character> matrix;
    private final List<Cell> stuckLights;

    LightGrid(Matrix<Character> matrix) {
        this(matrix, new ArrayList<>(0));
    }

    LightGrid(Matrix<Character> matrix, Collection<Cell> stuckLights) {
        this.matrix = matrix.copy();
        this.stuckLights = stuckLights.stream().toList();
    }

    LightGrid animate() {
        var result = matrix.copy();

        matrix.forEach(
                cv -> {
                    var next = getNextState(matrix, cv);
                    result.set(cv.cell(), next.getLabel());
                });

        return new LightGrid(result, stuckLights);
    }

    private Light getNextState(Matrix<Character> matrix, CellValue<Character> cv) {
        if (stuckLights.contains(cv.cell())) {
            return Light.ON;
        }

        var current = EnumUtils.of(Light.class, cv.value());
        var navigator = new NeighborsNavigator<>(matrix, cv.cell());
        var neighbors = navigator.collectElements(Direction.allOf());
        var neighborOnCount = neighbors.stream().filter(c -> Light.ON.getLabel().equals(c)).count();

        if (current == Light.ON && neighborOnCount != 2L && neighborOnCount != 3L) {
            return Light.OFF;
        }
        if (current == Light.OFF && neighborOnCount == 3L) {
            return Light.ON;
        }

        return current;
    }

    long getLightCount() {
        return matrix.stream().filter(cv -> Light.ON.getLabel().equals(cv.value())).count();
    }
}
