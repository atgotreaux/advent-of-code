package com.gotreaux.aoc.puzzles.year2023.day5;

import java.util.Collection;
import java.util.List;

class Almanac {
    private final List<List<AlmanacRange>> maps;

    Almanac(Collection<List<AlmanacRange>> maps) {
        this.maps = List.copyOf(maps);
    }

    long convert(long seed) {
        var value = seed;

        for (var map : maps) {
            for (var range : map) {
                if (range.isWithinRange(value)) {
                    value = range.getDestinationValue(value);
                    break;
                }
            }
        }

        return value;
    }
}
