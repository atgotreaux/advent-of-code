package com.gotreaux.aoc.puzzles.year2023.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.CharMatrix;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class GearRatiosPuzzle extends Puzzle {

    public GearRatiosPuzzle() {
        super(2023, 3);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int sumOfParts = 0;

        List<String> lines = inputReader.getInputList();
        CharMatrix matrix = new CharMatrix(lines);
        int rowCount = matrix.getRowCount();
        int columnCount = matrix.getColCount();

        Map<Point, List<Integer>> gearRatios = new HashMap<>();
        for (int lineRow = 0; lineRow < rowCount; lineRow++) {
            int number = 0;
            boolean adjacentToPart = false;
            Collection<Point> gears = new HashSet<>();
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix.get(lineRow, lineCol))) {
                    number = number * 10 + Character.digit(matrix.get(lineRow, lineCol), 10);
                    for (int adjacentLine = -1; adjacentLine < 2; adjacentLine++) {
                        for (int adjacentCol = -1; adjacentCol < 2; adjacentCol++) {
                            int row = adjacentLine + lineRow;
                            int col = adjacentCol + lineCol;
                            if (row >= 0 && row < rowCount && col >= 0 && col < columnCount) {
                                char adjacentChar = matrix.get(row, col);
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
                    gears.clear();

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
