package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;

class Board {

    private final Matrix<Integer> matrix;
    private final Collection<Cell> marked = new HashSet<>();

    Board(Matrix<Integer> matrix) {
        this.matrix = matrix.copy();
    }

    void mark(Integer drawn) {
        matrix.stream().filter(cv -> cv.value().equals(drawn)).forEach(cv -> marked.add(cv.cell()));
    }

    boolean isWinner() {
        return hasWinningRow() || hasWinningColumn();
    }

    private boolean hasWinningRow() {
        return IntStream.range(0, matrix.getRowCount()).anyMatch(this::isRowComplete);
    }

    private boolean isRowComplete(int row) {
        return IntStream.range(0, matrix.getColCount())
                .allMatch(col -> marked.contains(new Cell(row, col)));
    }

    private boolean hasWinningColumn() {
        return IntStream.range(0, matrix.getColCount()).anyMatch(this::isColumnComplete);
    }

    private boolean isColumnComplete(int col) {
        return IntStream.range(0, matrix.getRowCount())
                .allMatch(row -> marked.contains(new Cell(row, col)));
    }

    int getScore() {
        return matrix.stream()
                .filter(cv -> !marked.contains(cv.cell()))
                .mapToInt(cv -> matrix.get(cv.cell()))
                .sum();
    }
}
