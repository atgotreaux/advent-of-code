package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.Neighbors;
import java.util.function.Function;

class ModelArrivalFunction implements Function<Matrix<Character>, Matrix<Character>> {

    @Override
    public Matrix<Character> apply(Matrix<Character> matrix) {
        var result = matrix.copy();

        matrix.forEach(
                coordinate -> {
                    var next = getNextState(matrix, coordinate);
                    result.set(coordinate, next.getLabel());
                });

        return result;
    }

    private static Seat getNextState(Matrix<Character> matrix, Coordinate coordinate) {
        var current = EnumUtils.of(Seat.class, matrix.get(coordinate));
        if (current == Seat.FLOOR) {
            return Seat.FLOOR;
        }

        var neighbors = Neighbors.collectElements(matrix, coordinate, Direction.allOf());
        var occupiedNeighbors = neighbors.stream().filter(c -> c == '#').count();
        if (current == Seat.EMPTY && occupiedNeighbors == 0L) {
            return Seat.OCCUPIED;
        }
        if (current == Seat.OCCUPIED && occupiedNeighbors >= 4) {
            return Seat.EMPTY;
        }

        return current;
    }
}
