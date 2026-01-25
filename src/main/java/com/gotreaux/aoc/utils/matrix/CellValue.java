package com.gotreaux.aoc.utils.matrix;

public record CellValue<T>(Cell cell, T value) {

    static <T> CellValue<T> of(int row, int col, Matrix<T> matrix) {
        return new CellValue<>(new Cell(row, col), matrix.get(row, col));
    }
}
