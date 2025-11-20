package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.stream.IntStream;

record Board(Matrix<Integer> matrix) {

    void mark(Integer drawn) {
        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                if (drawn.equals(matrix.get(row, col))) {
                    matrix.visit(row, col);
                }
            }
        }
    }

    boolean isWinner() {
        var result =
                IntStream.range(0, matrix.getRowCount())
                        .anyMatch(
                                row ->
                                        IntStream.range(0, matrix.getColCount())
                                                .allMatch(col -> matrix.isVisited(row, col)));

        result |=
                IntStream.range(0, matrix.getColCount())
                        .anyMatch(
                                col ->
                                        IntStream.range(0, matrix.getRowCount())
                                                .allMatch(row -> matrix.isVisited(row, col)));

        return result;
    }

    int getScore() {
        var score = 0;

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                if (!matrix.isVisited(row, col)) {
                    score += matrix.get(row, col);
                }
            }
        }

        return score;
    }
}
