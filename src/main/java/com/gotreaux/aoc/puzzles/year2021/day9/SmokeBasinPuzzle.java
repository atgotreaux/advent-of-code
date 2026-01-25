package com.gotreaux.aoc.puzzles.year2021.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class SmokeBasinPuzzle extends Puzzle {

    public SmokeBasinPuzzle() {
        super(2021, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();
        var matrix = new Matrix<>(lines, new DigitMatrixProvider());

        var sumOfRiskLevels = matrix.stream().mapToInt(cv -> getRiskLevel(matrix, cv.cell())).sum();

        var productOfLargestBasins =
                matrix.stream()
                        .filter(
                                cv -> {
                                    var navigator = new NeighborsNavigator<>(matrix, cv.cell());
                                    var neighbors = navigator.collectElements(Direction.cardinal());
                                    return neighbors.stream().allMatch(i -> i > cv.value());
                                })
                        .map(cv -> getBasinSize(matrix, cv.cell()))
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .reduce(1, Math::multiplyExact);

        return new PuzzleOutput<>(sumOfRiskLevels, productOfLargestBasins);
    }

    private static int getRiskLevel(Matrix<Integer> matrix, Cell cell) {
        var element = matrix.get(cell);
        var navigator = new NeighborsNavigator<>(matrix, cell);
        var neighbors = navigator.collectElements(Direction.cardinal());
        if (neighbors.stream().allMatch(i -> i > element)) {
            return element + 1;
        }
        return 0;
    }

    static int getBasinSize(Matrix<Integer> matrix, Cell cell) {
        return getBasinSize(matrix, cell, new ArrayList<>());
    }

    private static int getBasinSize(Matrix<Integer> matrix, Cell cell, Collection<Cell> visited) {
        var size = 1;
        visited.add(cell);

        var navigator = new NeighborsNavigator<>(matrix, cell);
        for (var neighbor : navigator.collectCells(Direction.cardinal())) {
            if (matrix.get(neighbor) < 9 && !visited.contains(neighbor)) {
                size += getBasinSize(matrix, neighbor, visited);
            }
        }

        return size;
    }
}
