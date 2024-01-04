package com.gotreaux.year2016.day3;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class TrianglePuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        TrianglePuzzle puzzle = new TrianglePuzzle();

        puzzle.solve();
    }

    public TrianglePuzzle() {
        super();
    }

    public TrianglePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.map(
                            line -> {
                                Scanner scanner = new Scanner(line);

                                long a = scanner.nextLong();
                                long b = scanner.nextLong();
                                long c = scanner.nextLong();

                                scanner.close();

                                return new Triangle(a, b, c);
                            })
                    .filter(Triangle::isValid)
                    .count();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        List<Long> columnOne = new ArrayList<>();
        List<Long> columnTwo = new ArrayList<>();
        List<Long> columnThree = new ArrayList<>();

        for (String line : getInputProvider().getInputList()) {
            Scanner scanner = new Scanner(line);

            columnOne.add(scanner.nextLong());
            columnTwo.add(scanner.nextLong());
            columnThree.add(scanner.nextLong());

            scanner.close();
        }

        List<Triangle> triangles = new ArrayList<>();
        for (int i = 0; i < columnOne.size(); i += 3) {
            triangles.add(
                    new Triangle(columnOne.get(i), columnOne.get(i + 1), columnOne.get(i + 2)));
            triangles.add(
                    new Triangle(columnTwo.get(i), columnTwo.get(i + 1), columnTwo.get(i + 2)));
            triangles.add(
                    new Triangle(
                            columnThree.get(i), columnThree.get(i + 1), columnThree.get(i + 2)));
        }

        return triangles.stream().filter(Triangle::isValid).count();
    }
}
