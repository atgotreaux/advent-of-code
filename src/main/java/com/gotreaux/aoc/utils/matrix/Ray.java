package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.Coordinate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class Ray {

    private Ray() {}

    public static <T> List<T> collectElements(
            Matrix<T> matrix, int startRow, int startCol, Direction direction) {
        return collectElements(matrix, startRow, startCol, direction, new LimitPredicate());
    }

    public static <T> Map<Direction, List<T>> collectElements(
            Matrix<T> matrix, int row, int col, Collection<Direction> directions) {
        return collectElements(matrix, row, col, directions, new LimitPredicate());
    }

    public static <T> Map<Direction, List<T>> collectElements(
            Matrix<T> matrix, int row, int col, Collection<Direction> directions, int limit) {
        return collectElements(matrix, row, col, directions, new LimitPredicate(limit));
    }

    private static <T> Map<Direction, List<T>> collectElements(
            Matrix<T> matrix,
            int row,
            int col,
            Collection<Direction> directions,
            Predicate<Integer> limit) {
        return directions.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                direction -> collectElements(matrix, row, col, direction, limit)));
    }

    static <T> List<T> collectElements(
            Matrix<T> matrix,
            int startRow,
            int startCol,
            Direction direction,
            Predicate<Integer> limit) {
        List<T> elements = new ArrayList<>();

        var row = direction.adjustRow(startRow);
        var col = direction.adjustCol(startCol);

        while (matrix.isValid(row, col) && limit.test(elements.size())) {
            elements.add(matrix.get(row, col));
            row = direction.adjustRow(row);
            col = direction.adjustCol(col);
        }

        return elements;
    }

    static <T> List<T> collectElements(
            Matrix<T> matrix,
            Coordinate coordinate,
            Direction direction,
            Predicate<Integer> limit) {
        List<T> elements = new ArrayList<>();

        var row = direction.adjustRow(coordinate.x());
        var col = direction.adjustCol(coordinate.y());

        while (matrix.isValid(row, col) && limit.test(elements.size())) {
            elements.add(matrix.get(row, col));
            row = direction.adjustRow(row);
            col = direction.adjustCol(col);
        }

        return elements;
    }

    static <T> Collection<Coordinate> collectCoordinates(
            Matrix<T> matrix,
            int startRow,
            int startCol,
            Direction direction,
            Predicate<Integer> limit) {
        Collection<Coordinate> elements = new ArrayList<>();

        var row = direction.adjustRow(startRow);
        var col = direction.adjustCol(startCol);

        while (matrix.isValid(row, col) && limit.test(elements.size())) {
            elements.add(new Coordinate(row, col));
            row = direction.adjustRow(row);
            col = direction.adjustCol(col);
        }

        return elements;
    }
}
