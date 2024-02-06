package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;

public abstract class Wire {
    private final String label;

    protected Wire(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public abstract int evaluate(Circuit circuit);
}
