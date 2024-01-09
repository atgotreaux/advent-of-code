package com.gotreaux.aoc.puzzles.year2016.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2016, day = 3, title = "Squares With Three Sides")
public class TrianglePuzzle extends Puzzle {

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
