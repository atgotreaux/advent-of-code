package com.gotreaux.aoc.puzzles.year2020.day3;

import com.gotreaux.aoc.utils.Matrix;

record Slope(int right, int down) {
    int getTreesEncountered(Matrix map) {
        int treesEncountered = 0;

        int col = 0;
        for (int row = 0; row < map.getRowCount(); row += down) {
            if (col >= map.getColCount()) {
                col -= map.getColCount();
            }

            if (map.get(row, col) == '#') {
                treesEncountered++;
            }

            col += right;
        }

        return treesEncountered;
    }
}
