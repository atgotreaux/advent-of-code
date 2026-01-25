package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.matrix.provider.MatrixProvider;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Matrix<T> implements Iterable<CellValue<T>> {

    private final int rowCount;
    private final int colCount;
    private final T[][] grid;

    public Matrix(List<String> input, MatrixProvider<T> provider) {
        rowCount = input.size();
        colCount = (rowCount > 0) ? provider.mapRow(input.getFirst()).length : 0;
        grid = provider.initialize(rowCount, colCount);
        IntStream.range(0, rowCount).forEach(i -> grid[i] = provider.mapRow(input.get(i)));
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

    public T get(Cell cell) {
        return get(cell.row(), cell.col());
    }

    public void set(Cell cell, T value) {
        grid[cell.row()][cell.col()] = value;
    }

    public boolean isWithinBounds(Cell cell) {
        var row = cell.row();
        var col = cell.col();
        return row >= 0 && row < rowCount && col >= 0 && col < colCount;
    }

    @Override
    public Iterator<CellValue<T>> iterator() {
        return IntStream.range(0, rowCount)
                .boxed()
                .flatMap(
                        row ->
                                IntStream.range(0, colCount)
                                        .mapToObj(col -> CellValue.of(row, col, this)))
                .iterator();
    }

    public Stream<CellValue<T>> stream() {
        return StreamSupport.stream(spliterator(), false);
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
