package com.gotreaux.aoc.utils.matrix;

import com.gotreaux.aoc.utils.Coordinate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix<T> {

    private final int rowCount;
    private final int colCount;
    private final T[][] matrix;
    private final IntFunction<T[]> arrayGenerator;
    private final Collection<Coordinate> visited;

    Matrix(
            List<String> input,
            IntFunction<T[]> arrayGenerator,
            BiFunction<Integer, Integer, T[][]> matrixGenerator,
            Function<String, T[]> rowMapper) {
        rowCount = input.size();

        colCount =
                (rowCount > 0 && rowMapper.apply(input.getFirst()) != null)
                        ? rowMapper.apply(input.getFirst()).length
                        : 0;

        this.arrayGenerator = arrayGenerator;

        matrix = matrixGenerator.apply(rowCount, colCount);
        for (var i = 0; i < rowCount; i++) {
            matrix[i] = rowMapper.apply(input.get(i));
        }

        visited = new HashSet<>(rowCount * colCount);
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public T get(int row, int col) {
        return matrix[row][col];
    }

    public void set(int row, int col, T value) {
        matrix[row][col] = value;
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < rowCount && col >= 0 && col < colCount;
    }

    public void visit(int row, int col) {
        visited.add(new Coordinate(row, col));
    }

    public boolean isVisited(int row, int col) {
        return visited.contains(new Coordinate(row, col));
    }

    public void clearVisited() {
        visited.clear();
    }

    public T[] elementsInDirection(int startRow, int startCol, Direction direction) {
        return elementsInDirection(startRow, startCol, direction, new LimitPredicate());
    }

    private T[] elementsInDirection(
            int startRow, int startCol, Direction direction, Predicate<Integer> limitPredicate) {
        Collection<T> elements = new ArrayList<>();

        var row = direction.adjustRow(startRow);
        var col = direction.adjustCol(startCol);

        while (isValid(row, col) && limitPredicate.test(elements.size())) {
            elements.add(get(row, col));
            row = direction.adjustRow(row);
            col = direction.adjustCol(col);
        }

        return elements.toArray(arrayGenerator);
    }

    public Map<Direction, T[]> elementsinDirections(
            int row, int col, Direction[] directions, int limit) {
        return elementsinDirections(row, col, directions, new LimitPredicate(limit));
    }

    private Map<Direction, T[]> elementsinDirections(
            int row, int col, Direction[] directions, Predicate<Integer> limitPredicate) {
        return Stream.of(directions)
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                direction ->
                                        elementsInDirection(row, col, direction, limitPredicate)));
    }

    public T[] neighbors(int row, int col, Direction[] directions) {
        return neighbors(row, col, directions, new LimitPredicate(1));
    }

    private T[] neighbors(
            int row, int col, Direction[] directions, Predicate<Integer> limitPredicate) {
        return Stream.of(directions)
                .map(direction -> elementsInDirection(row, col, direction, limitPredicate))
                .flatMap(Stream::of)
                .toArray(arrayGenerator);
    }
}
