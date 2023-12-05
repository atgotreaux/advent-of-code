package com.gotreaux.twentythree;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Day3 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL resource = Day3.class.getClassLoader().getResource("com/gotreaux/twentythree/3.txt");
        if (resource == null) {
            System.out.println("Could not find input file");
            return;
        }

        Path path = Path.of(resource.toURI());

        Day3 day3 = new Day3();

        System.out.println("Part 1: " + day3.sumOfParts(path));
        System.out.println("Part 2: " + day3.sumOfGearRatios(path));
    }

    public int sumOfParts(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        int rowCount = lines.size();
        int columnCount = lines.get(0).length();

        char[][] matrix = new char[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        int sum = 0;
        for (int lineRow = 0; lineRow < rowCount; lineRow++) {
            int currentNumber = 0;
            AtomicBoolean adjacentToPart = new AtomicBoolean(false);
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix[lineRow][lineCol])) {
                    currentNumber = currentNumber * 10 + Integer.parseInt(String.valueOf(matrix[lineRow][lineCol]));
                    int finalLineCol = lineCol;
                    int finalLineRow = lineRow;
                    IntStream.range(-1, 2).forEach(adjacentLine -> IntStream.range(-1, 2).forEach(adjacentCol -> {
                        int adjustedRow = adjacentLine + finalLineRow;
                        int adjustedCol = adjacentCol + finalLineCol;
                        if (adjustedRow >= 0 && adjustedRow < rowCount && adjustedCol >= 0 && adjustedCol < columnCount) {
                            char adjacentChar = matrix[adjustedRow][adjustedCol];
                            if (!Character.isDigit(adjacentChar) && adjacentChar != '.') {
                                adjacentToPart.set(true);
                            }
                        }
                    }));
                } else if (currentNumber > 0) {
                    if (adjacentToPart.get()) {
                        sum += currentNumber;
                    }
                    currentNumber = 0;
                    adjacentToPart.set(false);
                }
            }
        }

        return sum;
    }

    public int sumOfGearRatios(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        int rowCount = lines.size();
        int columnCount = lines.get(0).length();

        char[][] matrix = new char[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        Map<Point, List<Integer>> gearRatios = new HashMap<>();
        for (int lineRow = 0; lineRow < rowCount; lineRow++) {
            int currentNumber = 0;
            Set<Point> gears = new HashSet<>();
            for (int lineCol = 0; lineCol < columnCount + 1; lineCol++) {
                if (lineCol < columnCount && Character.isDigit(matrix[lineRow][lineCol])) {
                    currentNumber = currentNumber * 10 + Integer.parseInt(String.valueOf(matrix[lineRow][lineCol]));
                    int finalLineCol = lineCol;
                    int finalLineRow = lineRow;
                    Set<Point> finalGears = gears;
                    IntStream.range(-1, 2).forEach(adjacentLine -> IntStream.range(-1, 2).forEach(adjacentCol -> {
                        int adjustedRow = adjacentLine + finalLineRow;
                        int adjustedCol = adjacentCol + finalLineCol;
                        if (adjustedRow >= 0 && adjustedRow < rowCount && adjustedCol >= 0 && adjustedCol < columnCount) {
                            char adjacentChar = matrix[adjustedRow][adjustedCol];
                            if (adjacentChar == '*') {
                                finalGears.add(new Point(adjustedRow, adjustedCol));
                            }
                        }
                    }));
                } else if (currentNumber > 0) {
                    for (Point gear : gears) {
                        if (gearRatios.containsKey(gear)) {
                            gearRatios.get(gear).add(currentNumber);
                        } else {
                            gearRatios.put(gear, new ArrayList<>(List.of(currentNumber)));
                        }
                    }
                    currentNumber = 0;
                    gears = new HashSet<>();
                }
            }
        }

        int productOfRatios = 0;
        for (Map.Entry<Point, List<Integer>> e : gearRatios.entrySet()) {
            List<Integer> gearNumbers = e.getValue();
            if (gearNumbers.size() == 2) {
                productOfRatios += gearNumbers.get(0) * gearNumbers.get(1);
            }
        }

        return productOfRatios;
    }
}
