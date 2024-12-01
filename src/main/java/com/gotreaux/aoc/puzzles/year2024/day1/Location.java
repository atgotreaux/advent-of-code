package com.gotreaux.aoc.puzzles.year2024.day1;

import java.util.Collection;
import java.util.Collections;

record Location(int id) implements Comparable<Location> {

    int getSimilarityScore(Collection<Location> locations) {
        int appearances = Collections.frequency(locations, this);

        return id * appearances;
    }

    @Override
    public int compareTo(Location o) {
        return Integer.compare(id, o.id());
    }
}
