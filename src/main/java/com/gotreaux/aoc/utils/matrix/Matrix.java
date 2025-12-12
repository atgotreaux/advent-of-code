package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.Coordinate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Matrix<T> {

    private final int rowCount;
    private final int colCount;
    private final T[][] grid;

    Matrix(
            List<String> input,
            BiFunction<Integer, Integer, T[][]> matrixGenerator,
            Function<String, T[]> rowMapper) {
        rowCount = input.size();

        colCount =
                (rowCount > 0 && rowMapper.apply(input.getFirst()) != null)
                        ? rowMapper.apply(input.getFirst()).length
                        : 0;

        grid = matrixGenerator.apply(rowCount, colCount);
        for (var i = 0; i < rowCount; i++) {
            grid[i] = rowMapper.apply(input.get(i));
        }
    }

    private Matrix(int rowCount, int colCount, T[][] grid) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.grid =
                Arrays.stream(grid)
                        .map(row -> Arrays.copyOf(row, row.length))
                        .toArray(size -> Arrays.copyOf(grid, size));
    }

    public Matrix<T> copy() {
        return new Matrix<>(rowCount, colCount, grid);
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    private T[][] getGrid() {
        return grid;
    }

    public T get(int row, int col) {
        return grid[row][col];
    }

    public T get(Coordinate coordinate) {
        return get(coordinate.x(), coordinate.y());
    }

    public void set(int row, int col, T value) {
        grid[row][col] = value;
    }

    public void set(Coordinate coordinate, T value) {
        set(coordinate.x(), coordinate.y(), value);
    }

    boolean isValid(int row, int col) {
        return row >= 0 && row < rowCount && col >= 0 && col < colCount;
    }

    public long count(T target) {
        return Stream.of(grid).flatMap(Stream::of).filter(target::equals).count();
    }

    public Optional<Coordinate> find(T target) {
        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < colCount; col++) {
                if (get(row, col).equals(target)) {
                    return Optional.of(new Coordinate(row, col));
                }
            }
        }

        return Optional.empty();
    }

    public List<Coordinate> findAll(T target) {
        List<Coordinate> coordinates = new ArrayList<>();

        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < colCount; col++) {
                if (get(row, col).equals(target)) {
                    coordinates.add(new Coordinate(row, col));
                }
            }
        }

        return coordinates;
    }

    public void forEach(Consumer<Coordinate> action) {
        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < colCount; col++) {
                action.accept(new Coordinate(row, col));
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Matrix<?> matrix)) {
            return false;
        }

        return rowCount == matrix.getRowCount()
                && colCount == matrix.getColCount()
                && Arrays.deepEquals(grid, matrix.getGrid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowCount, colCount, Arrays.deepHashCode(grid));
    }
}
