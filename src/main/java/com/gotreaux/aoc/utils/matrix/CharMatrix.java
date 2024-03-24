package com.gotreaux.aoc.utils.matrix;

import java.util.List;
import java.util.function.IntFunction;

public class CharMatrix extends Matrix<Character> {
    public CharMatrix(List<String> input) {
        super(input);
    }

    @Override
    Character[][] initialize() {
        return new Character[getRowCount()][getColCount()];
    }

    @Override
    protected Character[] mapper(String row) {
        return row.chars()
                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                .toArray(Character[]::new);
    }

    @Override
    IntFunction<Character[]> generator() {
        return Character[]::new;
    }
}
