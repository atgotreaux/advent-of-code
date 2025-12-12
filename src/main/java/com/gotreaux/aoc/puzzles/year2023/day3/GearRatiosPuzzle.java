package com.gotreaux.aoc.puzzles.year2023.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.Coordinate;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import com.gotreaux.aoc.utils.matrix.Neighbors;
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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();
        var matrix = MatrixFactory.ofChars(lines);

        var sumOfParts = 0;
        Map<Coordinate, List<Integer>> gearRatios = new HashMap<>();
        for (var row = 0; row < matrix.getRowCount(); row++) {
            var number = 0;
            var adjacentToPart = false;
            Collection<Coordinate> gears = new HashSet<>();
            for (var col = 0; col < matrix.getColCount() + 1; col++) {
                if (col < matrix.getColCount() && Character.isDigit(matrix.get(row, col))) {
                    number = number * 10 + Character.digit(matrix.get(row, col), 10);
                    var neighbors =
                            Neighbors.collectCoordinates(matrix, row, col, Direction.allOf());
                    for (var neighbor : neighbors) {
                        char adjacentChar = matrix.get(neighbor);
                        if (!Character.isDigit(adjacentChar) && adjacentChar != '.') {
                            adjacentToPart = true;
                        }
                        if (adjacentChar == '*') {
                            gears.add(neighbor);
                        }
                    }
                } else if (number > 0) {
                    if (adjacentToPart) {
                        sumOfParts += number;
                    }
                    adjacentToPart = false;

                    for (var gear : gears) {
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

        var sumOfGearRatios =
                gearRatios.values().stream()
                        .filter(gearNumbers -> gearNumbers.size() == 2)
                        .mapToInt(gearNumbers -> gearNumbers.getFirst() * gearNumbers.getLast())
                        .sum();

        return new PuzzleOutput<>(sumOfParts, sumOfGearRatios);
    }
}
