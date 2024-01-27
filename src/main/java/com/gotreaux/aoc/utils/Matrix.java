package com.gotreaux.aoc.utils;

import java.util.List;

public class Matrix {
    private final int rowCount;
    private final int colCount;
    private final char[][] matrix;

    public Matrix(List<String> input) {
        rowCount = input.size();
        colCount = input.getFirst().length();
        matrix = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            matrix[i] = input.get(i).toCharArray();
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public char get(int row, int col) {
        return matrix[row][col];
    }
}
