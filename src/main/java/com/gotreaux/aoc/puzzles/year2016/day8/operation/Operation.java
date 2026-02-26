package com.gotreaux.aoc.puzzles.year2016.day8.operation;

import com.gotreaux.aoc.utils.matrix.Matrix;

@FunctionalInterface
public interface Operation {

    void apply(Matrix<Character> matrix);
}
