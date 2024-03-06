package com.gotreaux.aoc.utils.matrix;

import java.util.List;

public class CharMatrix extends Matrix<Character> {
    public CharMatrix(List<String> input) {
        super(input);
    }

    @Override
    Character[][] initialize() {
        return new Character[getRowCount()][getColCount()];
    }

    @Override
    Character[] mapper(String row) {
        return row.chars()
                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                .toArray(Character[]::new);
    }
}
