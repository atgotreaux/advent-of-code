package com.gotreaux.aoc.puzzles.year2021.day5;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@ShellPuzzle(year = 2021, day = 5, title = "Hydrothermal Venture")
public class HydrothermalVenturePuzzle extends Puzzle {
    public HydrothermalVenturePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        Collection<Line> lines =
                getInputProvider()
                        .getInputStream()
                        .map(HydrothermalVenturePuzzle::parseLine)
                        .toList();

        Collection<Line> orthogonalLines =
                lines.stream().filter(line -> line.isHorizontal() || line.isVertical()).toList();

        Map<Point, Integer> points = new HashMap<>();
        for (Line line : orthogonalLines) {
            for (int row = line.getStartRow(); row <= line.getEndRow(); row++) {
                for (int col = line.getStartCol(); col <= line.getEndCol(); col++) {
                    points.merge(new Point(row, col), 1, Integer::sum);
                }
            }
        }
        long overlappingOrthogonalPoints = points.values().stream().filter(i -> i >= 2).count();

        return new PuzzleOutput<>(overlappingOrthogonalPoints, 0L);
    }

    private static Line parseLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",|\s->\s");

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        scanner.close();

        return new Line(x1, y1, x2, y2);
    }
}
