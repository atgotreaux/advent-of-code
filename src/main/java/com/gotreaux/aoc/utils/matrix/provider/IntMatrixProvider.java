package com.gotreaux.aoc.utils.matrix.provider;

import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.Arrays;

public class IntMatrixProvider implements MatrixProvider<Integer> {

    @Override
    public Integer[][] initialize(int rowCount, int colCount) {
        return new Integer[rowCount][colCount];
    }

    @Override
    public Integer[] mapRow(String rowInput) {
        return Arrays.stream(PatternUtils.ANY_WHITESPACE.split(rowInput.trim()))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
