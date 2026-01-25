package com.gotreaux.aoc.utils.matrix.navigator;

import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RayNavigator<T> extends MatrixNavigator<T> {

    public RayNavigator(Matrix<T> matrix, Cell startCell) {
        super(matrix, startCell);
    }

    public List<T> collectElements(Direction direction) {
        return collectElementsInDirection(direction, new LimitPredicate());
    }

    public List<T> collectElements(Direction direction, int limit) {
        return collectElementsInDirection(direction, new LimitPredicate(limit));
    }

    public Map<Direction, List<T>> collectElements(Collection<Direction> directions) {
        return collectElements(directions, new LimitPredicate());
    }

    public Map<Direction, List<T>> collectElements(Collection<Direction> directions, int limit) {
        return collectElements(directions, new LimitPredicate(limit));
    }

    private Map<Direction, List<T>> collectElements(
            Collection<Direction> directions, Predicate<Integer> limit) {
        return directions.stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                direction -> collectElementsInDirection(direction, limit)));
    }
}
