package com.gotreaux.aoc.utils.matrix.provider;

public class CharMatrixProvider implements MatrixProvider<Character> {

    @Override
    public Character[][] initialize(int rowCount, int colCount) {
        return new Character[rowCount][colCount];
    }

    @Override
    public Character[] mapRow(String rowInput) {
        return rowInput.chars()
                .mapToObj(codePoint -> Character.toString(codePoint).charAt(0))
                .toArray(Character[]::new);
    }
}
