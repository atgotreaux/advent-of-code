package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;

class Board {

    private final Matrix<Integer> matrix;
    private final Collection<Coordinate> marked = new HashSet<>();

    Board(Matrix<Integer> matrix) {
        this.matrix = matrix;
    }

    void mark(Integer drawn) {
        marked.addAll(matrix.findAll(drawn));
    }

    boolean isWinner() {
        return hasWinningRow() || hasWinningColumn();
    }

    private boolean hasWinningRow() {
        return IntStream.range(0, matrix.getRowCount()).anyMatch(this::isRowComplete);
    }

    private boolean isRowComplete(int row) {
        return IntStream.range(0, matrix.getColCount())
                .allMatch(col -> marked.contains(new Coordinate(row, col)));
    }

    private boolean hasWinningColumn() {
        return IntStream.range(0, matrix.getColCount()).anyMatch(this::isColumnComplete);
    }

    private boolean isColumnComplete(int col) {
        return IntStream.range(0, matrix.getRowCount())
                .allMatch(row -> marked.contains(new Coordinate(row, col)));
    }

    int getScore() {
        var score = 0;

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                if (!marked.contains(new Coordinate(row, col))) {
                    score += matrix.get(row, col);
                }
            }
        }

        return score;
    }
}
