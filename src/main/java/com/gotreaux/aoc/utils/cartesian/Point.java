package com.gotreaux.aoc.utils.cartesian;

public record Point(int x, int y) {

    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy);
    }

    public Point move(RelativeDirection direction, int units) {
        return switch (direction) {
            case UP -> new Point(x, y + units);
            case DOWN -> new Point(x, y - units);
            case LEFT -> new Point(x - units, y);
            case RIGHT -> new Point(x + units, y);
        };
    }

    public Point move(CardinalDirection direction, int units) {
        return switch (direction) {
            case NORTH -> new Point(x, y + units);
            case SOUTH -> new Point(x, y - units);
            case EAST -> new Point(x + units, y);
            case WEST -> new Point(x - units, y);
        };
    }
}
