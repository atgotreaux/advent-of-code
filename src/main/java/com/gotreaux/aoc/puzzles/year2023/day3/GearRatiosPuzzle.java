package com.gotreaux.aoc.puzzles.year2023.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

@ShellPuzzle(year = 2023, day = 3, title = "Gear Ratios")
public class GearRatiosPuzzle extends Puzzle {

    private int sumOfParts;
    private int sumOfGearRatios;

    public GearRatiosPuzzle(InputProvider inputProvider) throws Exception {
        super(inputProvider);

        prepare();
    }

    private void prepare() throws Exception {
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
            AtomicBoolean adjacentToPart = new AtomicBoolean(false);
            Set<Point> gears = new HashSet<>();
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix[lineRow][lineCol])) {
                    currentNumber =
                            currentNumber * 10
                                    + Integer.parseInt(String.valueOf(matrix[lineRow][lineCol]));
                    int finalLineCol = lineCol;
                    int finalLineRow = lineRow;
                    Set<Point> finalGears = gears;
                    IntStream.range(-1, 2)
                            .forEach(
                                    adjacentLine ->
                                            IntStream.range(-1, 2)
                                                    .forEach(
                                                            adjacentCol -> {
                                                                int adjustedRow =
                                                                        adjacentLine + finalLineRow;
                                                                int adjustedCol =
                                                                        adjacentCol + finalLineCol;
                                                                if (adjustedRow >= 0
                                                                        && adjustedRow < rowCount
                                                                        && adjustedCol >= 0
                                                                        && adjustedCol
                                                                                < columnCount) {
                                                                    char adjacentChar =
                                                                            matrix[adjustedRow][
                                                                                    adjustedCol];
                                                                    if (!Character.isDigit(
                                                                                    adjacentChar)
                                                                            && adjacentChar
                                                                                    != '.') {
                                                                        adjacentToPart.set(true);
                                                                    }
                                                                    if (adjacentChar == '*') {
                                                                        finalGears.add(
                                                                                new Point(
                                                                                        adjustedRow,
                                                                                        adjustedCol));
                                                                    }
                                                                }
                                                            }));
                } else if (currentNumber > 0) {
                    if (adjacentToPart.get()) {
                        sumOfParts += currentNumber;
                    }
                    adjacentToPart.set(false);

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

        for (Map.Entry<Point, List<Integer>> e : gearRatios.entrySet()) {
            List<Integer> gearNumbers = e.getValue();
            if (gearNumbers.size() == 2) {
                sumOfGearRatios += gearNumbers.get(0) * gearNumbers.get(1);
            }
        }
    }

    @Override
    public Integer getPartOne() {
        return sumOfParts;
    }

    @Override
    public Integer getPartTwo() {
        return sumOfGearRatios;
    }
}
