package com.gotreaux.aoc.puzzles.year2021.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class SmokeBasinPuzzle extends Puzzle {

    public SmokeBasinPuzzle() {
        super(2021, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var lines = inputReader.getInputList();
        var matrix = new IntMatrix(lines);

        var sumOfRiskLevels = 0;
        Collection<Integer> basinSizes = new ArrayList<>();

        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                int height = matrix.get(row, col);
                var neighbors = matrix.neighbors(row, col);

                if (Arrays.stream(neighbors).allMatch(i -> i > height)) {
                    sumOfRiskLevels += height + 1;
                    matrix.clearVisited();
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

    static int getBasinSize(IntMatrix matrix, int row, int col) {
        var size = 1;
        matrix.visit(row, col);

        if (row > 0 && matrix.get(row - 1, col) < 9 && !matrix.isVisited(row - 1, col)) {
            size += getBasinSize(matrix, row - 1, col);
        }
        if (row < matrix.getRowCount() - 1
                && matrix.get(row + 1, col) < 9
                && !matrix.isVisited(row + 1, col)) {
            size += getBasinSize(matrix, row + 1, col);
        }
        if (col > 0 && matrix.get(row, col - 1) < 9 && !matrix.isVisited(row, col - 1)) {
            size += getBasinSize(matrix, row, col - 1);
        }
        if (col < matrix.getColCount() - 1
                && matrix.get(row, col + 1) < 9
                && !matrix.isVisited(row, col + 1)) {
            size += getBasinSize(matrix, row, col + 1);
        }

        return size;
    }
}
