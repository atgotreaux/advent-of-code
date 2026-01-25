package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.RayNavigator;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class TreetopTreeHousePuzzle extends Puzzle {

    public TreetopTreeHousePuzzle() {
        super(2022, 8);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();
        var matrix = new Matrix<>(lines, new DigitMatrixProvider());

        var treesVisible = 0;
        var maxScenicScore = Integer.MIN_VALUE;
        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                int tree = matrix.get(row, col);

                var navigator = new RayNavigator<>(matrix, new Cell(row, col));
                var neighboringTrees = navigator.collectElements(Direction.cardinal());
                if (neighboringTrees.values().stream()
                        .anyMatch(adjacentTrees -> visible(adjacentTrees, tree))) {
                    treesVisible++;
                }

                var scenicScore =
                        neighboringTrees.values().stream()
                                .mapToInt(adjacentTrees -> score(adjacentTrees, tree))
                                .reduce(1, Math::multiplyExact);

                maxScenicScore = Math.max(maxScenicScore, scenicScore);
            }
        }

        return new PuzzleOutput<>(treesVisible, maxScenicScore);
    }

    private static boolean visible(Collection<Integer> adjacentTrees, int tree) {
        return adjacentTrees.stream().noneMatch(adjacentTree -> adjacentTree >= tree);
    }

    private static int score(List<Integer> adjacentTrees, int tree) {
        return IntStream.range(0, adjacentTrees.size())
                .boxed()
                .filter(index -> adjacentTrees.get(index) >= tree)
                .findFirst()
                .map(index -> index + 1)
                .orElse(adjacentTrees.size());
    }
}
