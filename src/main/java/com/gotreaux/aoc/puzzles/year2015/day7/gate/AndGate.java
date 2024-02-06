package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;

public class AndGate implements Gate {
    private final String x;
    private final String y;

    public AndGate(String x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int evaluate(Circuit circuit) {
        return circuit.evaluate(x) & circuit.evaluate(y);
    }
}
