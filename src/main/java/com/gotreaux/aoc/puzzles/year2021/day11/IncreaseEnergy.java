package com.gotreaux.aoc.puzzles.year2021.day11;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.CellValue;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;

class IncreaseEnergy implements Function<Matrix<Integer>, Matrix<Integer>> {

    @Override
    public Matrix<Integer> apply(Matrix<Integer> matrix) {
        var result = matrix.copy();

        result.forEach(cv -> result.set(cv.cell(), result.get(cv.cell()) + 1));

        Collection<Cell> flashed =
                result.stream()
                        .filter(cv -> cv.value() > 9)
                        .map(CellValue::cell)
                        .collect(Collectors.toSet());

        Queue<Cell> queue = new ArrayDeque<>(flashed);
        while (!queue.isEmpty()) {
            var cell = queue.poll();
            var navigator = new NeighborsNavigator<>(result, cell);
            for (var neighbor : navigator.collectCells(Direction.allOf())) {
                result.set(neighbor, result.get(neighbor) + 1);
                if (result.get(neighbor) > 9 && flashed.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        flashed.forEach(cell -> result.set(cell, 0));

        return result;
    }
}
