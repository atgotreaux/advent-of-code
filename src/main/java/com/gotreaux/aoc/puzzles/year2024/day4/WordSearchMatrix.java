package com.gotreaux.aoc.puzzles.year2024.day4;

import com.gotreaux.aoc.utils.matrix.CharMatrix;
import java.util.List;

class WordSearchMatrix extends CharMatrix {

    WordSearchMatrix(List<String> input) {
        super(input);
    }

    List<Character[]> getWords(int row, int col, int limit) {
        return List.of(
                up(row, col, limit),
                down(row, col, limit),
                left(row, col, limit),
                right(row, col, limit),
                southeast(row, col, limit),
                southwest(row, col, limit),
                northeast(row, col, limit),
                northwest(row, col, limit));
    }
}
