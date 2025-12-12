package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.Coordinate;
import java.util.Collection;
import java.util.function.Predicate;

public final class Neighbors {

    private Neighbors() {}

    public static <T> Collection<T> collectElements(
            Matrix<T> matrix, int row, int col, Collection<Direction> directions) {
        return collectElements(matrix, row, col, directions, new LimitPredicate(1));
    }

    public static <T> Collection<T> collectElements(
            Matrix<T> matrix, Coordinate coordinate, Collection<Direction> directions) {
        return collectElements(matrix, coordinate, directions, new LimitPredicate(1));
    }

    private static <T> Collection<T> collectElements(
            Matrix<T> matrix,
            int row,
            int col,
            Collection<Direction> directions,
            Predicate<Integer> limit) {
        return directions.stream()
                .map(direction -> Ray.collectElements(matrix, row, col, direction, limit))
                .flatMap(Collection::stream)
                .toList();
    }

    private static <T> Collection<T> collectElements(
            Matrix<T> matrix,
            Coordinate coordinate,
            Collection<Direction> directions,
            Predicate<Integer> limit) {
        return directions.stream()
                .map(direction -> Ray.collectElements(matrix, coordinate, direction, limit))
                .flatMap(Collection::stream)
                .toList();
    }

    public static <T> Collection<Coordinate> collectCoordinates(
            Matrix<T> matrix, int row, int col, Collection<Direction> directions) {
        return collectCoordinates(matrix, row, col, directions, new LimitPredicate(1));
    }

    private static <T> Collection<Coordinate> collectCoordinates(
            Matrix<T> matrix,
            int row,
            int col,
            Collection<Direction> directions,
            Predicate<Integer> limit) {
        return directions.stream()
                .map(direction -> Ray.collectCoordinates(matrix, row, col, direction, limit))
                .flatMap(Collection::stream)
                .toList();
    }
}
