package com.gotreaux.aoc.puzzles.year2015.day7.wire;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;

public class SignalWire extends Wire {
    private final String signal;

    public SignalWire(String label, String signal) {
        super(label);
        this.signal = signal;
    }

    @Override
    public int evaluate(Circuit circuit) {
        return circuit.evaluate(signal);
    }
}
