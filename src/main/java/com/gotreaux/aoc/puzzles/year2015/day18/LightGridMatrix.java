package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.utils.matrix.CharMatrix;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

final class LightGridMatrix extends CharMatrix {

    private static final char ON = '#';
    private static final char OFF = '.';

    private final List<Point> stuckLights;

    LightGridMatrix(List<String> input) {
        this(input, new ArrayList<>(0));
    }

    LightGridMatrix(List<String> input, Collection<Point> stuckLights) {
        super(input);
        this.stuckLights = stuckLights.stream().toList();

        for (var light : stuckLights) {
            set(light.x, light.y, ON);
        }
    }

    LightGridMatrix animate() {
        List<String> result = new ArrayList<>(getRowCount());

        for (var row = 0; row < getRowCount(); row++) {
            var resultRow = new StringBuilder(getColCount());
            for (var col = 0; col < getColCount(); col++) {
                resultRow.append(getNextState(row, col));
            }
            result.add(resultRow.toString());
        }

        return new LightGridMatrix(result, stuckLights);
    }

    private char getNextState(int row, int col) {
        if (stuckLights.contains(new Point(row, col))) {
            return ON;
        }
        var neighbors = getNeighboringLightCount(row, col);
        if (get(row, col) == ON) {
            return (neighbors == 2L || neighbors == 3L) ? ON : OFF;
        }
        return neighbors == 3L ? ON : OFF;
    }

    private long getNeighboringLightCount(int row, int col) {
        return Stream.of(
                        up(row, col, 1),
                        down(row, col, 1),
                        left(row, col, 1),
                        right(row, col, 1),
                        southeast(row, col, 1),
                        southwest(row, col, 1),
                        northeast(row, col, 1),
                        northwest(row, col, 1))
                .flatMap(Stream::of)
                .filter(c -> c == ON)
                .count();
    }

    int getLightCount() {
        var count = 0;

        for (var row = 0; row < getRowCount(); row++) {
            for (var col = 0; col < getColCount(); col++) {
                if (get(row, col) == ON) {
                    count++;
                }
            }
        }

        return count;
    }
}
