package com.gotreaux.aoc.puzzles.year2023.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ShellPuzzle(year = 2023, day = 3, title = "Gear Ratios")
public class GearRatiosPuzzle extends Puzzle {

    public GearRatiosPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int sumOfParts = 0;

        List<String> lines = getInputProvider().getInputList();
        int rowCount = lines.size();
        int columnCount = lines.getFirst().length();

        char[][] matrix = new char[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        Map<Point, List<Integer>> gearRatios = new HashMap<>();
        for (int lineRow = 0; lineRow < rowCount; lineRow++) {
            int currentNumber = 0;
            boolean adjacentToPart = false;
            Set<Point> gears = new HashSet<>();
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix[lineRow][lineCol])) {
                    currentNumber =
                            currentNumber * 10 + Character.digit(matrix[lineRow][lineCol], 10);
                    for (int adjacentLine = -1; adjacentLine < 2; adjacentLine++) {
                        for (int adjacentCol = -1; adjacentCol < 2; adjacentCol++) {
                            int adjustedRow = adjacentLine + lineRow;
                            int adjustedCol = adjacentCol + lineCol;
                            if (adjustedRow >= 0
                                    && adjustedRow < rowCount
                                    && adjustedCol >= 0
                                    && adjustedCol < columnCount) {
                                char adjacentChar = matrix[adjustedRow][adjustedCol];
                                if (!Character.isDigit(adjacentChar) && adjacentChar != '.') {
                                    adjacentToPart = true;
                                }
                                if (adjacentChar == '*') {
                                    gears.add(new Point(adjustedRow, adjustedCol));
                                }
                            }
                        }
                    }
                } else if (currentNumber > 0) {
                    if (adjacentToPart) {
                        sumOfParts += currentNumber;
                    }
                    adjacentToPart = false;

                    for (Point gear : gears) {
                        if (gearRatios.containsKey(gear)) {
                            gearRatios.get(gear).add(currentNumber);
                        } else {
                            gearRatios.put(gear, new ArrayList<>(List.of(currentNumber)));
                        }
                    }
                    gears = new HashSet<>();

                    currentNumber = 0;
                }
            }
        }

        int sumOfGearRatios =
                gearRatios.values().stream()
                        .filter(gearNumbers -> gearNumbers.size() == 2)
                        .mapToInt(gearNumbers -> gearNumbers.getFirst() * gearNumbers.getLast())
                        .sum();

        return new PuzzleOutput<>(sumOfParts, sumOfGearRatios);
    }
}
