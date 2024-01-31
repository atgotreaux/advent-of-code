package com.gotreaux.aoc.puzzles.year2015.day6;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.NoSuchElementException;

@ShellPuzzle(year = 2015, day = 6, title = "Probably a Fire Hazard")
public class FireHazardPuzzle extends Puzzle {
    public FireHazardPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException, NumberFormatException {
        Boolean[][] lightGrid = new Boolean[1000][1000];
        for (int row = 0; row < 1000; row++) {
            Boolean[] rowArray = new Boolean[1000];
            Arrays.fill(rowArray, Boolean.FALSE);
            lightGrid[row] = rowArray;
        }

        for (String line : getInputProvider().getInputList()) {
            Instruction instruction = Instruction.fromLine(line);

            String[] coordinates =
                    line.replace(instruction.getLabel(), "")
                            .replace(" through ", ",")
                            .trim()
                            .split(",");

            int startRow = Integer.parseInt(coordinates[0]);
            int startCol = Integer.parseInt(coordinates[1]);
            int endRow = Integer.parseInt(coordinates[2]);
            int endCol = Integer.parseInt(coordinates[3]);

            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    lightGrid[row][col] =
                            switch (instruction) {
                                case ON -> Boolean.TRUE;
                                case OFF -> Boolean.FALSE;
                                case TOGGLE -> Boolean.FALSE.equals(lightGrid[row][col]);
                            };
                }
            }
        }

        long lightsLit =
                Arrays.stream(lightGrid)
                        .flatMap(Arrays::stream)
                        .filter(Boolean::booleanValue)
                        .count();

        return new PuzzleOutput<>(lightsLit, 0);
    }
}
