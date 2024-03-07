package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@ShellPuzzle(year = 2022, day = 8, title = "Treetop Tree House")
public class TreetopTreeHousePuzzle extends Puzzle {
    public TreetopTreeHousePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve() throws IOException, URISyntaxException {
        List<String> lines = getInputProvider().getInputList();
        IntMatrix matrix = new IntMatrix(lines);

        int treesVisible = 0;
        long maxScenicScore = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.getRowCount(); row++) {
            for (int col = 0; col < matrix.getColCount(); col++) {
                int tree = matrix.get(row, col);

                Integer[] up = matrix.up(row, col);
                Integer[] down = matrix.down(row, col);
                Integer[] left = matrix.left(row, col);
                Integer[] right = matrix.right(row, col);

                if (visible(up, tree)
                        || visible(down, tree)
                        || visible(left, tree)
                        || visible(right, tree)) {
                    treesVisible++;
                }

                long scenicScore =
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
        int viewingDistance = 0;

        for (Integer adjacentTree : adjacentTrees) {
            viewingDistance++;
            if (adjacentTree >= tree) {
                break;
            }
        }

        return viewingDistance;
    }
}
