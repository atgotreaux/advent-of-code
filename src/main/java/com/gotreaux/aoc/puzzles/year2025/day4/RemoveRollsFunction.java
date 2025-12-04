package com.gotreaux.aoc.puzzles.year2025.day4;

import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.Arrays;
import java.util.function.Function;

class RemoveRollsFunction implements Function<Matrix<Character>, Matrix<Character>> {

    @Override
    public Matrix<Character> apply(Matrix<Character> matrix) {
        var result = MatrixFactory.ofMatrix(matrix);

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                var location = Location.of(matrix.get(row, col));
                var next = getNextState(location, matrix, row, col);
                result.set(row, col, next.getLabel());
            }
        }

        return result;
    }

    private static Location getNextState(
            Location current, Matrix<Character> matrix, int row, int col) {
        if (current == Location.PAPER_ROLL) {
            var neighbors = matrix.neighbors(row, col, Direction.values());
            var neighboringRolls =
                    Arrays.stream(neighbors)
                            .filter(c -> Location.PAPER_ROLL.getLabel() == c)
                            .count();
            if (neighboringRolls < 4L) {
                return Location.REMOVED_ROLL;
            }
            return Location.PAPER_ROLL;
        }

        return Location.EMPTY;
    }
}
