package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.Arrays;
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
        var matrix = MatrixFactory.ofDigits(lines);

        var treesVisible = 0;
        var maxScenicScore = Integer.MIN_VALUE;
        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                int tree = matrix.get(row, col);

                var up = matrix.elementsInDirection(row, col, Direction.NORTH);
                var down = matrix.elementsInDirection(row, col, Direction.SOUTH);
                var left = matrix.elementsInDirection(row, col, Direction.WEST);
                var right = matrix.elementsInDirection(row, col, Direction.EAST);

                if (visible(up, tree)
                        || visible(down, tree)
                        || visible(left, tree)
                        || visible(right, tree)) {
                    treesVisible++;
                }

                var scenicScore =
                        score(up, tree)
                                * score(down, tree)
                                * score(left, tree)
                                * score(right, tree);
                maxScenicScore = Math.max(maxScenicScore, scenicScore);
            }
        }

        return new PuzzleOutput<>(treesVisible, maxScenicScore);
    }

    private static boolean visible(Integer[] adjacentTrees, int tree) {
        return Arrays.stream(adjacentTrees).noneMatch(adjacentTree -> adjacentTree >= tree);
    }

    private static int score(Integer[] adjacentTrees, int tree) {
        return IntStream.range(0, adjacentTrees.length)
                .boxed()
                .filter(index -> adjacentTrees[index] >= tree)
                .findFirst()
                .map(index -> index + 1)
                .orElse(adjacentTrees.length);
    }
}
