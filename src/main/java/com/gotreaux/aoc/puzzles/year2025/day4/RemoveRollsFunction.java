package com.gotreaux.aoc.puzzles.year2025.day4;

import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.Neighbors;
import java.util.function.Function;

class RemoveRollsFunction implements Function<Matrix<Character>, Matrix<Character>> {

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

    private static Location getNextState(Matrix<Character> matrix, Coordinate coordinate) {
        var current = EnumUtils.of(Location.class, matrix.get(coordinate));
        if (current == Location.PAPER_ROLL) {
            var neighbors = Neighbors.collectElements(matrix, coordinate, Direction.allOf());
            var neighboringRolls =
                    neighbors.stream()
                            .filter(c -> Location.PAPER_ROLL.getLabel().equals(c))
                            .count();
            if (neighboringRolls < 4L) {
                return Location.REMOVED_ROLL;
            }
            return Location.PAPER_ROLL;
        }

        return Location.EMPTY;
    }
}
