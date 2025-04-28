package com.gotreaux.aoc.puzzles.year2015.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class FireHazardPuzzle extends Puzzle {
    private static final int GRID_DIMENSION = 1000;

    public FireHazardPuzzle() {
        super(2015, 6);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        boolean[][] lightGrid = new boolean[GRID_DIMENSION][GRID_DIMENSION];
        int[][] brightnessGrid = new int[GRID_DIMENSION][GRID_DIMENSION];

        for (String line : inputReader.getInputList()) {
            Instruction instruction = Instruction.of(line);

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
                    switch (instruction) {
                        case ON -> {
                            lightGrid[row][col] = true;
                            brightnessGrid[row][col]++;
                        }
                        case OFF -> {
                            lightGrid[row][col] = false;
                            brightnessGrid[row][col] = Math.max(0, brightnessGrid[row][col] - 1);
                        }
                        case TOGGLE -> {
                            lightGrid[row][col] = !lightGrid[row][col];
                            brightnessGrid[row][col] += 2;
                        }
                    }
                }
            }
        }

        long lightsLit =
                Arrays.stream(lightGrid)
                        .flatMap(row -> IntStream.range(0, GRID_DIMENSION).mapToObj(i -> row[i]))
                        .filter(Boolean::booleanValue)
                        .count();

        long brightnessLit = Arrays.stream(brightnessGrid).flatMapToInt(Arrays::stream).sum();

        return new PuzzleOutput<>(lightsLit, brightnessLit);
    }
}
