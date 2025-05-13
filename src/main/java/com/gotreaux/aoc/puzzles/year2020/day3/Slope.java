package com.gotreaux.aoc.puzzles.year2020.day3;

import com.gotreaux.aoc.utils.matrix.CharMatrix;

record Slope(int right, int down) {
    int getTreesEncountered(CharMatrix map) {
        var treesEncountered = 0;

        var col = 0;
        for (var row = 0; row < map.getRowCount(); row += down) {
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
