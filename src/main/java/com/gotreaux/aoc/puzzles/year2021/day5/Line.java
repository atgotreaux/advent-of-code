package com.gotreaux.aoc.puzzles.year2021.day5;

import com.gotreaux.aoc.utils.Coordinate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

record Line(int x1, int y1, int x2, int y2) {

    static Line of(String line) {
        var scanner = new Scanner(line);
        scanner.useDelimiter(",| -> ");

        var x1 = scanner.nextInt();
        var y1 = scanner.nextInt();
        var x2 = scanner.nextInt();
        var y2 = scanner.nextInt();

        scanner.close();

        return new Line(x1, y1, x2, y2);
    }

    boolean isHorizontal() {
        return x1 == x2;
    }

    boolean isVertical() {
        return y1 == y2;
    }

    Collection<Coordinate> getPoints() {
        Collection<Coordinate> points =
                new ArrayList<>(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));

        var row = x1;
        var col = y1;
        while (row != x2 || col != y2) {
            points.add(new Coordinate(row, col));
            if (x1 > x2) {
                row--;
            }
            if (x1 < x2) {
                row++;
            }
            if (y1 > y2) {
                col--;
            }
            if (y1 < y2) {
                col++;
            }
        }
        points.add(new Coordinate(row, col));

        return points;
    }
}
