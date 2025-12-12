package com.gotreaux.aoc.puzzles.year2021.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import com.gotreaux.aoc.utils.matrix.Neighbors;
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
        var matrix = MatrixFactory.ofDigits(lines);

        var sumOfRiskLevels = 0;
        Collection<Integer> basinSizes = new ArrayList<>();

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                int height = matrix.get(row, col);
                var neighbors = Neighbors.collectElements(matrix, row, col, Direction.cardinal());

                if (neighbors.stream().allMatch(i -> i > height)) {
                    sumOfRiskLevels += height + 1;
                    basinSizes.add(getBasinSize(matrix, row, col));
                }
            }
        }

        int productOfLargestBasins =
                basinSizes.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .reduce(1, Math::multiplyExact);

        return new PuzzleOutput<>(sumOfRiskLevels, productOfLargestBasins);
    }

    static int getBasinSize(Matrix<Integer> matrix, int row, int col) {
        return getBasinSize(matrix, row, col, new ArrayList<>());
    }

    private static int getBasinSize(
            Matrix<Integer> matrix, int row, int col, Collection<Coordinate> visited) {
        var size = 1;
        visited.add(new Coordinate(row, col));

        for (var neighbor : Neighbors.collectCoordinates(matrix, row, col, Direction.cardinal())) {
            if (matrix.get(neighbor.x(), neighbor.y()) < 9 && !visited.contains(neighbor)) {
                size += getBasinSize(matrix, neighbor.x(), neighbor.y(), visited);
            }
        }

        return size;
    }
}
