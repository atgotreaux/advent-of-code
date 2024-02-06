package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;
import com.gotreaux.aoc.puzzles.year2015.day7.gate.Gate;

public class GateWire extends Wire {
    private final Gate gate;

    public GateWire(String label, Gate gate) {
        super(label);
        this.gate = gate;
    }

    @Override
    public int evaluate(Circuit circuit) {
        return gate.evaluate(circuit);
    }
}
