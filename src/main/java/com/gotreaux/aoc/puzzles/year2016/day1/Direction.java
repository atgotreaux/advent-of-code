package com.gotreaux.aoc.puzzles.year2016.day1;

import java.awt.Point;

enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    Point move(Point point, int units) {
        return switch (this) {
            case NORTH -> new Point(point.x, point.y + units);
            case SOUTH -> new Point(point.x, point.y - units);
            case EAST -> new Point(point.x + units, point.y);
            case WEST -> new Point(point.x - units, point.y);
        };
    }

    Direction turn(Instruction instruction) {
        return switch (this) {
            case NORTH -> instruction == Instruction.RIGHT ? EAST : WEST;
            case SOUTH -> instruction == Instruction.RIGHT ? WEST : EAST;
            case EAST -> instruction == Instruction.RIGHT ? SOUTH : NORTH;
            case WEST -> instruction == Instruction.RIGHT ? NORTH : SOUTH;
        };
    }
}
