package com.gotreaux.aoc.puzzles.year2023.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
            int number = 0;
            boolean adjacentToPart = false;
            Collection<Point> gears = new HashSet<>();
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix[lineRow][lineCol])) {
                    number = number * 10 + Character.digit(matrix[lineRow][lineCol], 10);
                    for (int adjacentLine = -1; adjacentLine < 2; adjacentLine++) {
                        for (int adjacentCol = -1; adjacentCol < 2; adjacentCol++) {
                            int row = adjacentLine + lineRow;
                            int col = adjacentCol + lineCol;
                            if (row >= 0 && row < rowCount && col >= 0 && col < columnCount) {
                                char adjacentChar = matrix[row][col];
                                if (!Character.isDigit(adjacentChar) && adjacentChar != '.') {
                                    adjacentToPart = true;
                                }
                                if (adjacentChar == '*') {
                                    gears.add(new Point(row, col));
                                }
                            }
                        }
                    }
                } else if (number > 0) {
                    if (adjacentToPart) {
                        sumOfParts += number;
                    }
                    adjacentToPart = false;

                    for (Point gear : gears) {
                        if (gearRatios.containsKey(gear)) {
                            gearRatios.get(gear).add(number);
                        } else {
                            gearRatios.put(gear, new ArrayList<>(List.of(number)));
                        }
                    }
                    gears = new HashSet<>();

                    number = 0;
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
