package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.Arrays;
import java.util.function.Function;

class ModelArrivalFunction implements Function<Matrix<Character>, Matrix<Character>> {

    @Override
    public Matrix<Character> apply(Matrix<Character> matrix) {
        var result = MatrixFactory.ofMatrix(matrix);

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                var seat = EnumUtils.of(Seat.class, matrix.get(row, col));
                var next = getNextState(seat, matrix, row, col);
                result.set(row, col, next.getLabel());
            }
        }

        return result;
    }

    private static Seat getNextState(Seat current, Matrix<Character> matrix, int row, int col) {
        if (current == Seat.FLOOR) {
            return Seat.FLOOR;
        }

        var neighbors = matrix.neighbors(row, col, Direction.values());
        var occupiedNeighbors = Arrays.stream(neighbors).filter(c -> c == '#').count();
        if (current == Seat.EMPTY && occupiedNeighbors == 0L) {
            return Seat.OCCUPIED;
        }
        if (current == Seat.OCCUPIED && occupiedNeighbors >= 4) {
            return Seat.EMPTY;
        }

        return current;
    }
}
