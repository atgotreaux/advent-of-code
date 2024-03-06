package com.gotreaux.aoc.utils.matrix;

import java.util.List;

public class IntMatrix extends Matrix<Integer> {
    public IntMatrix(List<String> input) {
        super(input);
    }

    @Override
    Integer[][] initialize() {
        return new Integer[getRowCount()][getColCount()];
    }

    @Override
    Integer[] mapper(String row) {
        return row.chars()
                .map(codePoint -> Character.digit(codePoint, 10))
                .boxed()
                .toArray(Integer[]::new);
    }
}
