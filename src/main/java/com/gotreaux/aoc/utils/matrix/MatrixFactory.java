package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.regex.PatternUtils;
import java.util.Arrays;
import java.util.List;

public final class MatrixFactory {

    private MatrixFactory() {}

    public static Matrix<Integer> ofDigits(List<String> input) {
        return new Matrix<>(
                input,
                (rowCount, colCount) -> new Integer[rowCount][colCount],
                row ->
                        row.chars()
                                .map(codePoint -> Character.digit(codePoint, 10))
                                .boxed()
                                .toArray(Integer[]::new));
    }

    public static Matrix<Integer> ofInts(List<String> input) {
        return new Matrix<>(
                input,
                (rowCount, colCount) -> new Integer[rowCount][colCount],
                row ->
                        Arrays.stream(PatternUtils.ANY_WHITESPACE.split(row.trim()))
                                .map(Integer::parseInt)
                                .toArray(Integer[]::new));
    }

    public static Matrix<Character> ofChars(List<String> input) {
        return new Matrix<>(
                input,
                (rowCount, colCount) -> new Character[rowCount][colCount],
                row ->
                        row.chars()
                                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                                .toArray(Character[]::new));
    }
}
