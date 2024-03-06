package com.gotreaux.aoc.utils.matrix;

import java.util.List;

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

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public T get(int row, int col) {
        return matrix[row][col];
    }
}
