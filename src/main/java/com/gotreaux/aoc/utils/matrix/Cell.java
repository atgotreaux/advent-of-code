package com.gotreaux.aoc.utils.matrix;

public record Cell(int row, int col) {

    public Cell move(Direction direction) {
        return switch (direction) {
            case NORTH -> new Cell(row - 1, col);
            case SOUTH -> new Cell(row + 1, col);
            case EAST -> new Cell(row, col + 1);
            case WEST -> new Cell(row, col - 1);
            case SOUTHEAST -> new Cell(row + 1, col + 1);
            case SOUTHWEST -> new Cell(row + 1, col - 1);
            case NORTHEAST -> new Cell(row - 1, col + 1);
            case NORTHWEST -> new Cell(row - 1, col - 1);
        };
    }
}
