package com.gotreaux.aoc.utils.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

abstract class Matrix<T> {
    private final int rowCount;
    private final int colCount;
    private final T[][] matrix;

    Matrix(List<String> input) {
        rowCount = input.size();
        colCount = input.getFirst().length();
        matrix = initialize();

        for (int i = 0; i < rowCount; i++) {
            matrix[i] = mapper(input.get(i));
        }
    }

    abstract T[][] initialize();

    abstract T[] mapper(String row);

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

    public T[] up(int row, int col) {
        return IntStream.range(0, row)
                .map(i -> row - i - 1)
                .mapToObj(i -> get(i, col))
                .toArray(generator());
    }

    public T[] down(int row, int col) {
        return IntStream.range(row + 1, rowCount).mapToObj(i -> get(i, col)).toArray(generator());
    }

    public T[] left(int row, int col) {
        return IntStream.range(0, col)
                .map(i -> col - i - 1)
                .mapToObj(i -> get(row, i))
                .toArray(generator());
    }

    public T[] right(int row, int col) {
        return IntStream.range(col + 1, colCount).mapToObj(i -> get(row, i)).toArray(generator());
    }

    public T[] neighbors(int row, int col) {
        Stream<T> neighbors = Stream.of();

        T[] up = up(row, col);
        if (up.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(up, 0, 1)));
        }

        T[] down = down(row, col);
        if (down.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(down, 0, 1)));
        }

        T[] left = left(row, col);
        if (left.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(left, 0, 1)));
        }

        T[] right = right(row, col);
        if (right.length > 0) {
            neighbors = Stream.concat(neighbors, Arrays.stream(Arrays.copyOfRange(right, 0, 1)));
        }

        return neighbors.toArray(generator());
    }
}
