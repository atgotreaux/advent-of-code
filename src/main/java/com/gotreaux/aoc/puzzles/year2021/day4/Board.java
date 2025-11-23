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
        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                if (drawn.equals(matrix.get(row, col))) {
                    marked.add(new Coordinate(row, col));
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
                                                .allMatch(
                                                        col ->
                                                                marked.contains(
                                                                        new Coordinate(row, col))));

        result |=
                IntStream.range(0, matrix.getColCount())
                        .anyMatch(
                                col ->
                                        IntStream.range(0, matrix.getRowCount())
                                                .allMatch(
                                                        row ->
                                                                marked.contains(
                                                                        new Coordinate(row, col))));

        return result;
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
