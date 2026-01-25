package com.gotreaux.aoc.puzzles.year2025.day4;

import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.CellValue;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import java.util.function.Function;

class RemoveRollsFunction implements Function<Matrix<Character>, Matrix<Character>> {

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

    private static Location getNextState(Matrix<Character> matrix, CellValue<Character> cv) {
        var current = EnumUtils.of(Location.class, cv.value());
        if (current == Location.PAPER_ROLL) {
            var navigator = new NeighborsNavigator<>(matrix, cv.cell());
            var neighbors = navigator.collectElements(Direction.allOf());
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
