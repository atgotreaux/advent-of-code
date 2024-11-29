package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TreetopTreeHousePuzzle extends Puzzle {

    public TreetopTreeHousePuzzle() {
        super(2022, 8);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) throws Exception {
        List<String> lines = inputReader.getInputList();
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
