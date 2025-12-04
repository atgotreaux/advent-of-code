package com.gotreaux.aoc.puzzles.year2015.day6;

record Instruction(int startRow, int startCol, int endRow, int endCol, Action action) {

    static Instruction of(String line) {
        var action = Action.of(line);

        var coordinateParts =
                line.replace(action.getLabel(), "").replace(" through ", ",").trim().split(",");

        if (coordinateParts.length != 4) {
            throw new IllegalArgumentException(
                    "Unexpected format for coordinates: '%s'".formatted(line));
        }

        var startRow = Integer.parseInt(coordinateParts[0]);
        var startCol = Integer.parseInt(coordinateParts[1]);
        var endRow = Integer.parseInt(coordinateParts[2]);
        var endCol = Integer.parseInt(coordinateParts[3]);

        return new Instruction(startRow, startCol, endRow, endCol, action);
    }

    Instruction {
        if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0) {
            throw new IllegalArgumentException("Coordinate range values must be greater than 0");
        }
    }

    void apply(boolean[][] lightGrid) {
        for (var row = startRow; row <= endRow; row++) {
            for (var col = startCol; col <= endCol; col++) {
                switch (action) {
                    case ON -> lightGrid[row][col] = true;
                    case OFF -> lightGrid[row][col] = false;
                    case TOGGLE -> lightGrid[row][col] = !lightGrid[row][col];
                }
            }
        }
    }

    void apply(int[][] brightnessGrid) {
        for (var row = startRow; row <= endRow; row++) {
            for (var col = startCol; col <= endCol; col++) {
                switch (action) {
                    case ON -> brightnessGrid[row][col]++;
                    case OFF ->
                            brightnessGrid[row][col] = Math.max(0, brightnessGrid[row][col] - 1);
                    case TOGGLE -> brightnessGrid[row][col] += 2;
                }
            }
        }
    }
}
