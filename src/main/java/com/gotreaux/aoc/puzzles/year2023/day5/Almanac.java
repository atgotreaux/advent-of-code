package com.gotreaux.aoc.puzzles.year2023.day5;

import java.util.List;

class Almanac {
    private final List<List<AlmanacRange>> maps;

    Almanac(List<List<AlmanacRange>> maps) {
        this.maps = maps;
    }

    long convert(long seed) {
        long value = seed;

        for (List<AlmanacRange> map : maps) {
            for (AlmanacRange range : map) {
                if (range.isWithinRange(value)) {
                    value = range.getDestinationValue(value);
                    break;
                }
            }
        }

        return value;
    }
}
