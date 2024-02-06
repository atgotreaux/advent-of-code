package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;

public class NotGate implements Gate {
    private final String x;

    public NotGate(String x) {
        this.x = x;
    }

    @Override
    public int evaluate(Circuit circuit) {
        return ~circuit.evaluate(x) & 0xFFFF;
    }
}
