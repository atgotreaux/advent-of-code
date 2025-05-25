package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class TreetopTreeHousePuzzle extends Puzzle {

    public TreetopTreeHousePuzzle() {
        super(2022, 8);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();
        var matrix = new IntMatrix(lines);

        var treesVisible = 0;
        long maxScenicScore = Integer.MIN_VALUE;
        for (var row = 0; row < matrix.getRowCount(); row++) {
            for (var col = 0; col < matrix.getColCount(); col++) {
                int tree = matrix.get(row, col);

                var up = matrix.up(row, col);
                var down = matrix.down(row, col);
                var left = matrix.left(row, col);
                var right = matrix.right(row, col);

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

    private static long score(Integer[] adjacentTrees, int tree) {
        var viewingDistance = 0;

        for (var adjacentTree : adjacentTrees) {
            viewingDistance++;
            if (adjacentTree >= tree) {
                break;
            }
        }

        return viewingDistance;
    }
}
