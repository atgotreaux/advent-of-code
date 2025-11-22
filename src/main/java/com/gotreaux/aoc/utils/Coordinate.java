package com.gotreaux.aoc.utils;

public record Coordinate(int x, int y) {

    public Coordinate translate(int dx, int dy) {
        return new Coordinate(x + dx, y + dy);
    }

    public Coordinate move(RelativeDirection direction, int units) {
        return switch (direction) {
            case UP -> new Coordinate(x, y + units);
            case DOWN -> new Coordinate(x, y - units);
            case LEFT -> new Coordinate(x - units, y);
            case RIGHT -> new Coordinate(x + units, y);
        };
    }

    public Coordinate move(CardinalDirection direction, int units) {
        return switch (direction) {
            case NORTH -> new Coordinate(x, y + units);
            case SOUTH -> new Coordinate(x, y - units);
            case EAST -> new Coordinate(x + units, y);
            case WEST -> new Coordinate(x - units, y);
        };
    }
}
