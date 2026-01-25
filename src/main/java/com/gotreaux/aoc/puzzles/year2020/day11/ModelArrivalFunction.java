package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.CellValue;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import java.util.function.Function;

class ModelArrivalFunction implements Function<Matrix<Character>, Matrix<Character>> {

    @Override
    public Matrix<Character> apply(Matrix<Character> matrix) {
        var result = matrix.copy();

        matrix.forEach(
                cv -> {
                    var next = getNextState(matrix, cv);
                    result.set(cv.cell(), next.getLabel());
                });

        return result;
    }

    private static Seat getNextState(Matrix<Character> matrix, CellValue<Character> cv) {
        var current = EnumUtils.of(Seat.class, cv.value());
        if (current == Seat.FLOOR) {
            return Seat.FLOOR;
        }

        var navigator = new NeighborsNavigator<>(matrix, cv.cell());
        var neighbors = navigator.collectElements(Direction.allOf());
        var occupiedNeighbors =
                neighbors.stream().filter(c -> Seat.OCCUPIED.getLabel().equals(c)).count();
        if (current == Seat.EMPTY && occupiedNeighbors == 0L) {
            return Seat.OCCUPIED;
        }
        if (current == Seat.OCCUPIED && occupiedNeighbors >= 4) {
            return Seat.EMPTY;
        }

        return current;
    }
}
