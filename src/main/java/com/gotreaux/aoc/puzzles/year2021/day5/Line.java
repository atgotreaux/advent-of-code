package com.gotreaux.aoc.puzzles.year2021.day5;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

record Line(int x1, int y1, int x2, int y2) {
    boolean isHorizontal() {
        return x1 == x2;
    }

    boolean isVertical() {
        return y1 == y2;
    }

    Collection<Point> getPoints() {
        Collection<Point> points = new ArrayList<>(Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2)));

        int row = x1;
        int col = y1;
        while (row != x2 || col != y2) {
            points.add(new Point(row, col));
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
        points.add(new Point(row, col));

        return points;
    }
}
