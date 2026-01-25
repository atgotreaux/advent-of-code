package com.gotreaux.aoc.utils.matrix.provider;

public class DigitMatrixProvider implements MatrixProvider<Integer> {

    @Override
    public Integer[][] initialize(int rowCount, int colCount) {
        return new Integer[rowCount][colCount];
    }

    @Override
    public Integer[] mapRow(String rowInput) {
        return rowInput.chars()
                .map(codePoint -> Character.digit(codePoint, 10))
                .boxed()
                .toArray(Integer[]::new);
    }
}
