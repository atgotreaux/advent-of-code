package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Board extends IntMatrix {
    Board(List<String> input) {
        super(input);
    }

    @Override
    protected Integer[] mapper(String row) {
        var scanner = new Scanner(row);

        var result = scanner.tokens().map(Integer::parseInt).toArray(Integer[]::new);

        scanner.close();

        return result;
    }

    void mark(Integer drawn) {
        for (var row = 0; row < getRowCount(); row++) {
            for (var col = 0; col < getColCount(); col++) {
                if (drawn.equals(get(row, col))) {
                    visit(row, col);
                }
            }
        }
    }

    boolean isWinner() {
        var result =
                IntStream.range(0, getRowCount())
                        .anyMatch(
                                row ->
                                        IntStream.range(0, getColCount())
                                                .allMatch(col -> isVisited(row, col)));

        result |=
                IntStream.range(0, getColCount())
                        .anyMatch(
                                col ->
                                        IntStream.range(0, getRowCount())
                                                .allMatch(row -> isVisited(row, col)));

        return result;
    }

    int getScore() {
        var score = 0;

        for (var row = 0; row < getRowCount(); row++) {
            for (var col = 0; col < getColCount(); col++) {
                if (!isVisited(row, col)) {
                    score += get(row, col);
                }
            }
        }

        return score;
    }
}
