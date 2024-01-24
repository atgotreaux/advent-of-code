package com.gotreaux.aoc.puzzles.year2017.day3;

import java.awt.Point;

enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    Point move(Point point) {
        return switch (this) {
            case NORTH -> new Point(point.x, point.y + 1);
            case SOUTH -> new Point(point.x, point.y - 1);
            case EAST -> new Point(point.x + 1, point.y);
            case WEST -> new Point(point.x - 1, point.y);
        };
    }

    Direction turn() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
}
