package com.gotreaux.aoc.utils.matrix.navigator;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

class MatrixNavigator<T> {

    private final Matrix<T> matrix;
    private final Cell startCell;

    MatrixNavigator(Matrix<T> matrix, Cell startCell) {
        this.matrix = matrix;
        this.startCell = startCell;
    }

    List<T> collectElementsInDirection(Direction direction, Predicate<Integer> limit) {
        List<T> elements = new ArrayList<>();

        var cell = startCell.move(direction);
        while (matrix.isWithinBounds(cell) && limit.test(elements.size())) {
            elements.add(matrix.get(cell));
            cell = cell.move(direction);
        }

        return elements;
    }

    Collection<Cell> collectCellsInDirection(Direction direction, Predicate<Integer> limit) {
        Collection<Cell> cells = new ArrayList<>();

        var cell = startCell.move(direction);
        while (matrix.isWithinBounds(cell) && limit.test(cells.size())) {
            cells.add(cell);
            cell = cell.move(direction);
        }

        return cells;
    }
}
