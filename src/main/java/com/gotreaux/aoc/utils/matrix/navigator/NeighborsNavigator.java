package com.gotreaux.aoc.utils.matrix.navigator;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.Collection;
import java.util.function.Predicate;

public class NeighborsNavigator<T> extends MatrixNavigator<T> {

    public NeighborsNavigator(Matrix<T> matrix, Cell startCell) {
        super(matrix, startCell);
    }

    public Collection<T> collectElements(Collection<Direction> directions) {
        return collectElements(directions, new LimitPredicate(1));
    }

    private Collection<T> collectElements(
            Collection<Direction> directions, Predicate<Integer> limit) {
        return directions.stream()
                .map(direction -> collectElementsInDirection(direction, limit))
                .flatMap(Collection::stream)
                .toList();
    }

    public Collection<Cell> collectCells(Collection<Direction> directions) {
        return collectCells(directions, new LimitPredicate(1));
    }

    private Collection<Cell> collectCells(
            Collection<Direction> directions, Predicate<Integer> limit) {
        return directions.stream()
                .map(direction -> collectCellsInDirection(direction, limit))
                .flatMap(Collection::stream)
                .toList();
    }
}
