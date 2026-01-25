package com.gotreaux.aoc.utils.matrix.provider;

public interface MatrixProvider<T> {

    T[][] initialize(int rowCount, int colCount);

    T[] mapRow(String rowInput);
}
