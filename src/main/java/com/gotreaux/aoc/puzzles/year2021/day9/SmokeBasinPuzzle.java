package com.gotreaux.aoc.puzzles.year2021.day9;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.IntMatrix;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@ShellPuzzle(year = 2021, day = 9, title = "Smoke Basin")
public class SmokeBasinPuzzle extends Puzzle {
    public SmokeBasinPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        List<String> lines = getInputProvider().getInputList();
        IntMatrix matrix = new IntMatrix(lines);

        int sumOfRiskLevels = 0;
        for (int row = 0; row < matrix.getRowCount(); row++) {
            for (int col = 0; col < matrix.getColCount(); col++) {
                int height = matrix.get(row, col);
                Integer[] neighbors = matrix.neighbors(row, col);

                if (Arrays.stream(neighbors).allMatch(i -> i > height)) {
                    sumOfRiskLevels += height + 1;
                }
            }
        }

        return new PuzzleOutput<>(sumOfRiskLevels, 0);
    }
}
