package com.gotreaux.aoc.puzzles.year2016.day8.operation;

public final class OperationFactory {

    private OperationFactory() {}

    public static Operation of(String line) {
        return switch (line) {
            case String s when s.startsWith("rect") -> RectOperation.of(line);
            case String s when s.startsWith("rotate row") -> RotateRowOperation.of(line);
            case String s when s.startsWith("rotate column") -> RotateColumnOperation.of(line);
            default -> throw new IllegalArgumentException("Unknown operation: " + line);
        };
    }
}
