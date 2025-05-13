package com.gotreaux.aoc.utils.matrix;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

abstract class Matrix<T> {
    private final int rowCount;
    private final int colCount;
    private final T[][] matrix;
    private final Collection<Point> visited;

    Matrix(List<String> input) {
        rowCount = input.size();

        matrix = initialize();
        for (var i = 0; i < rowCount; i++) {
            matrix[i] = mapper(input.get(i));
        }

        colCount = matrix[0].length;

        visited = new HashSet<>(rowCount * colCount);
    }

    abstract T[][] initialize();

    protected abstract T[] mapper(String row);

    abstract IntFunction<T[]> generator();

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public T get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, T value) {
        matrix[row][col] = value;
    }

    public void visit(int row, int col) {
        visited.add(new Point(row, col));
    }

    public boolean isVisited(int row, int col) {
        return visited.contains(new Point(row, col));
    }

    public void clearVisited() {
        visited.clear();
    }

    public T[] up(int row, int col) {
        return direction(row, col, i -> i - 1, i -> i, new LimitPredicate());
    }

    protected T[] up(int row, int col, int limit) {
        return direction(row, col, i -> i - 1, i -> i, new LimitPredicate(limit));
    }

    public T[] down(int row, int col) {
        return direction(row, col, i -> i + 1, i -> i, new LimitPredicate());
    }

    protected T[] down(int row, int col, int limit) {
        return direction(row, col, i -> i + 1, i -> i, new LimitPredicate(limit));
    }

    public T[] left(int row, int col) {
        return direction(row, col, i -> i, i -> i - 1, new LimitPredicate());
    }

    protected T[] left(int row, int col, int limit) {
        return direction(row, col, i -> i, i -> i - 1, new LimitPredicate(limit));
    }

    public T[] right(int row, int col) {
        return direction(row, col, i -> i, i -> i + 1, new LimitPredicate());
    }

    protected T[] right(int row, int col, int limit) {
        return direction(row, col, i -> i, i -> i + 1, new LimitPredicate(limit));
    }

    protected T[] southeast(int row, int col, int limit) {
        return direction(row, col, i -> i + 1, i -> i + 1, new LimitPredicate(limit));
    }

    protected T[] southwest(int row, int col, int limit) {
        return direction(row, col, i -> i + 1, i -> i - 1, new LimitPredicate(limit));
    }

    protected T[] northeast(int row, int col, int limit) {
        return direction(row, col, i -> i - 1, i -> i + 1, new LimitPredicate(limit));
    }

    protected T[] northwest(int row, int col, int limit) {
        return direction(row, col, i -> i - 1, i -> i - 1, new LimitPredicate(limit));
    }

    private T[] direction(
            int startRow,
            int startCol,
            Function<Integer, Integer> adjustRow,
            Function<Integer, Integer> adjustCol,
            Predicate<Integer> limitPredicate) {
        Collection<T> elements = new ArrayList<>();

        int row = adjustRow.apply(startRow);
        int col = adjustCol.apply(startCol);

        while (isValid(row, col) && limitPredicate.test(elements.size())) {
            elements.add(get(row, col));
            row = adjustRow.apply(row);
            col = adjustCol.apply(col);
        }

        return elements.toArray(generator());
    }

    public T[] neighbors(int row, int col) {
        Stream<T> neighbors = Stream.of();

        var up = up(row, col);
        if (up.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(up, 0, 1)));
        }

        var down = down(row, col);
        if (down.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(down, 0, 1)));
        }

        var left = left(row, col);
        if (left.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(left, 0, 1)));
        }

        var right = right(row, col);
        if (right.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(right, 0, 1)));
        }

        return neighbors.toArray(generator());
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rowCount && col >= 0 && col < colCount;
    }
}
