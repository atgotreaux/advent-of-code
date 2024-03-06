package com.gotreaux.aoc.puzzles.year2022.day8;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@ShellPuzzle(year = 2022, day = 8, title = "Treetop Tree House")
public class TreetopTreeHousePuzzle extends Puzzle {
    public TreetopTreeHousePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        List<String> lines = getInputProvider().getInputList();
        IntMatrix matrix = new IntMatrix(lines);

        int treesVisible = 0;
        for (int lineRow = 0; lineRow < matrix.getRowCount(); lineRow++) {
            for (int lineCol = 0; lineCol < matrix.getColCount(); lineCol++) {
                if (visibleFromTop(matrix, lineRow, lineCol)
                        || visibleFromBottom(matrix, lineRow, lineCol)
                        || visibleFromLeft(matrix, lineRow, lineCol)
                        || visibleFromRight(matrix, lineRow, lineCol)) {
                    treesVisible++;
                }
            }
        }

        return new PuzzleOutput<>(treesVisible, 0);
    }

    private static boolean visibleFromTop(IntMatrix matrix, int row, int col) {
        int tree = matrix.get(row, col);
        for (int adjacentRow = row - 1; adjacentRow >= 0; adjacentRow--) {
            if (matrix.get(adjacentRow, col) >= tree) {
                return false;
            }
        }
        return true;
    }

    private static boolean visibleFromBottom(IntMatrix matrix, int row, int col) {
        int tree = matrix.get(row, col);
        for (int adjacentRow = row + 1; adjacentRow < matrix.getRowCount(); adjacentRow++) {
            if (matrix.get(adjacentRow, col) >= tree) {
                return false;
            }
        }
        return true;
    }

    private static boolean visibleFromLeft(IntMatrix matrix, int row, int col) {
        int tree = matrix.get(row, col);
        for (int adjacentCol = col - 1; adjacentCol >= 0; adjacentCol--) {
            if (matrix.get(row, adjacentCol) >= tree) {
                return false;
            }
        }
        return true;
    }

    private static boolean visibleFromRight(IntMatrix matrix, int row, int col) {
        int tree = matrix.get(row, col);
        for (int adjacentCol = col + 1; adjacentCol < matrix.getColCount(); adjacentCol++) {
            if (matrix.get(row, adjacentCol) >= tree) {
                return false;
            }
        }
        return true;
    }
}
